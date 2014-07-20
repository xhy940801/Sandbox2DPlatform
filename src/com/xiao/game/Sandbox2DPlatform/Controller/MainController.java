package com.xiao.game.Sandbox2DPlatform.Controller;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.GameObjFilter.DistanceFilter;
import com.xiao.game.Sandbox2DPlatform.GameObjFilter.GameBlankFilter;
import com.xiao.game.Sandbox2DPlatform.Message.MessageCallBackRegister;
import com.xiao.game.Sandbox2DPlatform.Message.MessageDispenser;
import com.xiao.game.Sandbox2DPlatform.ObjContainer.ObjContainer;
import com.xiao.game.Sandbox2DPlatform.Object.ChangeableObj;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 游戏程序主执行器
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Controller.Context
 * 		com.xiao.game.Sandbox2DPlatform.Controller.Executable
 */
public class MainController implements Context, Executable
{
	private double flushDistance;
	
	private ObjContainerManager objContainerManager;
	private MessageDispenser messageDispenser;
	private MessageCallBackRegister messageCallBackRegister;
	private GameTimerManager gameTimerManager;
	
	private Executable exe;

	public MainController()
	{
		exe = this;
	}
	
	/**
	 * 执行下一帧
	 * @param millisecond int 上一帧到这一帧之间间隔的毫秒数
	 */
	public void nextTick(int millisecond)
	{
		exe.nextTick(millisecond, this);
	}
	
	@Override
	public void nextTick(int millisecond, Context context)
	{
		ObjContainer playerObjContainer = objContainerManager.getPlayerObjContainer();
		Filter<GameObj> filter = GameBlankFilter.getBlankFilter();
		for(GameObj gObj : playerObjContainer)
			filter = filter.or(new DistanceFilter(gObj.getCenterPoint(), flushDistance));
		
		ObjContainer changeableObjContainer = objContainerManager.getChangeableObjContainer();
		changeableObjContainer.setFilter(filter);
		for(GameObj gObj : changeableObjContainer)
			((ChangeableObj) gObj).nextTick(millisecond, this);
	}

	@Override
	public void pause(Executable exe)
	{
		this.exe = exe;
	}

	@Override
	public void resume()
	{
		this.exe = this;
	}

	@Override
	public MessageDispenser getMessageDispenser()
	{
		return messageDispenser;
	}

	@Override
	public ObjContainerManager getObjContainerManager()
	{
		return objContainerManager;
	}

	@Override
	public MessageCallBackRegister getMessageCallBackRegister()
	{
		return messageCallBackRegister;
	}

	/**
	 * @return the flushDistance
	 */
	public double getFlushDistance()
	{
		return flushDistance;
	}

	/**
	 * @param flushDistance the flushDistance to set
	 */
	public void setFlushDistance(double flushDistance)
	{
		this.flushDistance = flushDistance;
	}

	public GameTimerManager getGameTimerManager()
	{
		return gameTimerManager;
	}
}
