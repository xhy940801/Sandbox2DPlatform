package com.xiao.game.Sandbox2DPlatform.Object;

/**
 * 静态物品的接口
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
 */
public interface StaticObj extends GameObj
{
	/**
	 * 获取本静态物体的高度
	 * @return int 高度
	 */
	public int height();
}
