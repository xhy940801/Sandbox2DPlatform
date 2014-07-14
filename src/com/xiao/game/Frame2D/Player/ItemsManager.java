package com.xiao.game.Frame2D.Player;

import com.xiao.game.Frame2D.ItemsBag.ItemsBag;

/**
 * 物品管理器接口
 * @author xiao.hy
 * @see com.xiao.game.Frame2D.ItemsBag.ItemsBag
 */
public interface ItemsManager
{
	public ItemsBag getItemBag(String bagName);
}
