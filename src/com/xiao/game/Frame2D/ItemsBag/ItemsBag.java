package com.xiao.game.Frame2D.ItemsBag;

import java.util.List;

import com.xiao.game.Frame2D.Item.Item;
import com.xiao.game.Sandbox2DPlatform.Filter.Filter;

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
	public Item getItemByPosition(int position);
	
	/**
	 * 获取物品包中指定id的物品
	 * @param id int id
	 * @return Item 物品
	 */
	public Item getItemById(int id);
	
	/**
	 * 获取物品集合
	 * @param filter Filter<Item> 物品过滤器
	 * @param list List<Item> Item存入的List
	 */
	public void getItem(Filter<Item> filter, List<Item> list);
	
	/**
	 * 获取物品包名称
	 * @return String 物品包名称(必须全Context唯一)
	 */
	public String getBagName();
}
