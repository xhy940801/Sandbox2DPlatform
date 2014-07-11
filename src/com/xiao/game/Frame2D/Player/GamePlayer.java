package com.xiao.game.Frame2D.Player;

import com.xiao.game.Frame2D.Algorithm.Calculator;
import com.xiao.game.Sandbox2DPlatform.Controller.Context;
import com.xiao.game.Sandbox2DPlatform.Object.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Object.MoveableObj;
import com.xiao.game.Sandbox2DPlatform.Object.Point;
import com.xiao.game.Sandbox2DPlatform.Object.RulableObj;

public class GamePlayer extends MoveableObj implements RulableObj
{
	private float speed;
	private Operation op;

	public GamePlayer(Point point, int id, float speed)
	{
		super(point, id);
		this.speed = speed;
		op = new Operation();
		
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
		double dx = 
	}
	
	protected double getDistance(int millisecond, float move)
	{
		return move * millisecond;
	}
	
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
