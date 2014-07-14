package com.xiao.game.Frame2D.ItemsBag;

import com.xiao.game.Frame2D.Item.Item;

/**
 * 物品包接口
 * @author xiao.hy
 * @see com.xiao.game.Frame2D.Item.Item
 */
public interface ItemsBag
{
	/**
	 * 获取物品包中指定位置的物品
	 * @param position int 位置
	 * @return Item 物品
	 */
	public Item getItem(int position);
	
	/**
	 * 获取物品包名称
	 * @return String 物品包名称(必须全Context唯一)
	 */
	public String getBagName();
}
