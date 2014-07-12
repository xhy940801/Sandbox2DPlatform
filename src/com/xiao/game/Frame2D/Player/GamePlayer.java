package com.xiao.game.Frame2D.Player;

import java.util.Map;

import com.xiao.game.Frame2D.Algorithm.Calculator;
import com.xiao.game.Frame2D.Config.MapConfig;
import com.xiao.game.Frame2D.Config.OperationConfig;
import com.xiao.game.Sandbox2DPlatform.Controller.Context;
import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Data.Point;
import com.xiao.game.Sandbox2DPlatform.ObjContainer.StaticObjContainer;
import com.xiao.game.Sandbox2DPlatform.Object.MoveableObj;
import com.xiao.game.Sandbox2DPlatform.Object.RulableObj;
import com.xiao.game.Sandbox2DPlatform.Object.StaticObj;

/**
 * 这是一个玩家类，负责对玩家的控制
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
 *		com.xiao.game.Sandbox2DPlatForm.Object.RulableObj
 *		com.xiao.game.Sandbox2DPlatForm.Object.MoveableObj	
 */
public class GamePlayer extends MoveableObj implements RulableObj
{
	protected float speed;
	protected Operation op;
	protected int jumpHeight, fallingHeight;
	protected float  collisionRadius;
	
	protected Map<Integer, Operator> opMap;

	@Override
	public MapCoordinate getMapCoordinate()
	{
		return Calculator.toCoordinate(point);
	}

	/**
	 * 这是GamePlayer的构造函数
	 * @param point Point player的当前位置
	 * @param id int GameObj的id属性
	 * @param speed float player的移动速度
	 * @param jumpHeight int player的最大跳跃高度
	 * @param fallingHeight int player的最大坠落高度
	 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
	 */
	public GamePlayer(Point point, int id, float speed, int jumpHeight, int fallingHeight)
	{
		super(point, id);
		this.speed = speed;
		op = new Operation();
		this.jumpHeight = jumpHeight;
		this.fallingHeight = fallingHeight;
	}

	@Override
	public void nextTick(int millisecond, Context context)
	{
		this.doMove(millisecond, context);
		this.doOperation(millisecond, context);
	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public void move(float x, float y)
	{
		op.moveX = x;
		op.moveY = y;
	}

	@Override
	public void operate(int operationCode, Object operation)
	{
		op.operationCode = operationCode;
		op.operation = operation;
	}
	
	/**
	 * 进行player的移动处理
	 * @param millisecond int 上一个tick到这个tick的间隔时间,单位: 毫秒;
	 * @param context Context 游戏的上下文
	 * @see com.xiao.game.Sandbox2DPlatform.Controller.Context
	 */
	protected void doMove(int millisecond, Context context)
	{
		double dx = this.getDistance(millisecond, op.moveX);
		double dy = this.getDistance(millisecond, op.moveY);
		StaticObjContainer sObjContainer = context.getObjContainerManager().getStaticObjContainer();
		double x = point.getX() + dx;
		double y = point.getY() + dy;
		if(this.isAbleToStandAt(x, y, sObjContainer))
		{
			point.setX(x);
			point.setY(y);
		}
	}
	
	/**
	 * 进行player的操作处理
	 * @param millisecond int 上一个tick到这个tick的间隔时间,单位: 毫秒;
	 * @param context Context 游戏的上下文
	 * @see com.xiao.game.Sandbox2DPlatform.Controller.Context
	 */
	protected void doOperation(int millisecond, Context context)
	{
		opMap.get(op.operationCode).operate(op.operation, this, millisecond, context);
	}
	
	/**
	 * 获取所移动的距离
	 * @param millisecond int 上一个tick到这个tick的间隔时间,单位: 毫秒;
	 * @param move float 移动参数,范围[-1.0, 1.0],一般是用move函数所获得的x或者y来作为参数,来获取x或y的相对移动量
	 * @return double 移动的距离
	 * @see com.xiao.game.Sandbox2DPlatform.Object.RulableObj
	 */
	protected double getDistance(int millisecond, float move)
	{
		return move * millisecond * speed;
	}
	
	/**
	 * 确认player是否能站在点(x, y)处
	 * @param x double player将要去的坐标的x值
	 * @param y	double player将要去的坐标的y值
	 * @param sObjContainer StaticObjContainer 用来获取各个位置的静态物体
	 * @return boolean 是否能站在点(x, y)处
	 */
	protected boolean isAbleToStandAt(double x, double y, StaticObjContainer sObjContainer)
	{
		MapCoordinate cCoordinate = Calculator.toCoordinate(point);		//获取现在位置所在的地图坐标
		MapCoordinate tCoordinate = Calculator.toCoordinate(x, y);		//获取将要到达的位置所在的地图坐标
		
		StaticObj csObj = (StaticObj) sObjContainer.getObjByCoordinate(cCoordinate);		//获取当前所在位置的静态物体
		StaticObj tsObj = (StaticObj) sObjContainer.getObjByCoordinate(tCoordinate);		//获取将要到达的位置的静态物体
		
		if(tsObj.height() - csObj.height() > jumpHeight || csObj.height() - tsObj.height() > fallingHeight)		//检查高度差是否合适
			return false;
		
		Point tPoint = tsObj.getCenterPoint();		//获取将要达到的位置的中心位置坐标
		
		//计算将要到达的位置坐标和将要到达的地图坐标的差值
		double dx = tPoint.getX() - x;
		double dy = tPoint.getY() - y;
		
		double ox, oy, oz;
		
		//离将要到达的坐标最近的角坐标
		double cornerX, cornerY;
		
		int tcx = tCoordinate.getX();
		int tcy = tCoordinate.getY();
		
		//xswap和yswap是用来表示离将要到达的坐标附近的地图坐标的偏移量
		int xswap, yswap;
		//设置xswap,yswap,cornerX,cornerY,ox,oy
		if(dx < 0.0)
		{
			xswap = 1;
			cornerX = tPoint.getX() - MapConfig.getPerPieceRadius();
			ox = MapConfig.getPerPieceRadius() + dx;
		}
		else
		{
			xswap = -1;
			cornerX = tPoint.getX() + MapConfig.getPerPieceRadius();
			ox = MapConfig.getPerPieceRadius() - dx;
		}
		
		if(dy < 0.0)
		{
			yswap = 1;
			cornerY = tPoint.getY() - MapConfig.getPerPieceRadius();
			oy = MapConfig.getPerPieceRadius() + dy;
		}
		else
		{
			yswap = -1;
			cornerY = tPoint.getY() + MapConfig.getPerPieceRadius();
			oy = MapConfig.getPerPieceRadius() - dy;
		}
		
		double dcx = cornerX - x;
		double dcy = cornerY - y;
		//计算oz
		oz = Math.sqrt(dcx * dcx + dcy * dcy);
		
		if(ox < collisionRadius)
		{
			StaticObj xcsObj = (StaticObj) sObjContainer.getObjByCoordinate(tcx + xswap, tcy);
			if(tsObj.height() - xcsObj.height() > jumpHeight || xcsObj.height() - tsObj.height() > fallingHeight)
				return false;
		}
		
		if(oy < collisionRadius)
		{
			StaticObj ycsObj = (StaticObj) sObjContainer.getObjByCoordinate(tcx, tcy + yswap);
			if(tsObj.height() - ycsObj.height() > jumpHeight || ycsObj.height() - tsObj.height() > fallingHeight)
				return false;
		}
		
		if(oz < collisionRadius)
		{
			StaticObj zcsObj = (StaticObj) sObjContainer.getObjByCoordinate(tcx + xswap, tcy + yswap);
			if(tsObj.height() - zcsObj.height() > jumpHeight || zcsObj.height() - tsObj.height() > fallingHeight)
				return false;
		}
		return true;
	}

	/**
	 * 内部类Operation
	 * 用来记录外部设备对player的命令
	 * @author xiao.hy
	 *
	 */
	private class Operation
	{
		public float moveX, moveY;	//move的x, y值在区间[-1.0f, 1.0f]之间
		public int operationCode;	//操作码
		public Object operation;	//具体操作
		
		/**
		 * 构造函数,进行初始化操作
		 * 调用了方法clear
		 */
		public Operation()
		{
			this.clear();
		}
		
		/**
		 * 清空信息
		 */
		public void clear()
		{
			moveX = 0.0f;
			moveY = 0.0f;
			operationCode = OperationConfig.OP_NONE;
			operation = null;
		}
		
		/**
		 * 只清空操作信息,不清空移动信息
		 */
		public void clearOperation()
		{
			operationCode = OperationConfig.OP_NONE;
			operation = null;
		}
	}

}
