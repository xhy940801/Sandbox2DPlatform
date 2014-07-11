package com.xiao.game.Sandbox2DPlatform.Object;

public interface RulableObj extends ChangeableObj
{
	/**
	 * Set the direction and speed and when next tick, position of the GameObj will be flush.
	 * @param x [-1, 1].
	 * @param y [-1, 1].
	 */
	public void move(float x, float y);
	public void operate(int operationCode, Object operation);
	
}
