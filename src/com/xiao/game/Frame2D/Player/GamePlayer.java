package com.xiao.game.Frame2D.Player;

import com.xiao.game.Frame2D.Algorithm.Calculator;
import com.xiao.game.Sandbox2DPlatform.Controller.Context;
import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Data.Point;
import com.xiao.game.Sandbox2DPlatform.Object.MoveableObj;
import com.xiao.game.Sandbox2DPlatform.Object.RulableObj;

public class GamePlayer extends MoveableObj implements RulableObj
{
	protected float speed;
	protected Operation op;
	protected int jumpHeight;

	@Override
	public MapCoordinate getMapCoordinate()
	{
		return Calculator.toCoordinate(point);
	}

	public GamePlayer(Point point, int id, float speed, int jumpHeight)
	{
		super(point, id);
		this.speed = speed;
		op = new Operation();
		this.jumpHeight = jumpHeight;
	}

	@Override
	public void nextTick(int millisecond, Context context)
	{
		this.doMove(millisecond, context);
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
	
	protected void doMove(int millisecond, Context context)
	{
		double dx = getDistance(millisecond, op.moveX);
		double dy = getDistance(millisecond, op.moveY);

	}
	
	protected double getDistance(int millisecond, float move)
	{
		return move * millisecond * speed;
	}
	
	// protected boolean isAbleToStandAt(double x, double y, StaticObjContainer
	// sObjContainer)
	// {
	// MapCoordinate cCoordinate = Calculator.toCoordinate(point);
	// MapCoordinate tCoordinate = Calculator.toCoordinate(x, y);
	//
	// StaticObj tsObj = (StaticObj)
	// sObjContainer.getObjByCoordinate(this.getMapCoordinate());
	// StaticObj csObj = (StaticObj) sObjContainer.getObjByCoordinate(mc)
	// }

	private class Operation
	{
		public float moveX, moveY;
		public int operationCode;
		public Object operation;
		
		public Operation()
		{
			this.clear();
		}
		
		public void clear()
		{
			moveX = 0.0f;
			moveY = 0.0f;
			operationCode = 0;
			operation = null;
		}
		
		public void clearOperation()
		{
			operationCode = 0;
			operation = null;
		}
	}

}
