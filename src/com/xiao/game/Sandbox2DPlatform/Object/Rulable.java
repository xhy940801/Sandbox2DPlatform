package com.xiao.game.Sandbox2DPlatform.Object;

/**
 * 可被控制的物体的接口
 * @author xiao.hy
 * @see Open Declaration com.xiao.game.Sandbox2DPlatform.Object.ChangeableObj
 */
public interface Rulable extends Changeable
{
	/**
	 * Set the direction and speed and when next tick, position of the GameObj will be flush.
	 * @param x [-1, 1].
	 * @param y [-1, 1].
	 */
	public void move(float x, float y);
	
	/**
	 * 下一个tick要执行的操作
	 * @param operationCode int 操作码
	 * @param operation Object 具体操作信息
	 */
	public void operate(int operationCode, Object operation);
	
}
