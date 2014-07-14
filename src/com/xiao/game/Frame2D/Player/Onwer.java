package com.xiao.game.Frame2D.Player;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 物主接口
 * 这个接口定义了一种拥有一个物品管理器的GameObj
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
 *		com.xiao.game.Frame2D.Player.ItemsManager
 */
public interface Onwer extends GameObj
{
	/**
	 * 返回物品管理器
	 * @return ItemsManager 物品管理器
	 */
	public ItemsManager getItemsManager();
}
