package com.xiao.game.Frame2D.Item;

/**
 * 物品接口
 * @author xiao.hy
 */
public interface Item
{
	/**
	 * 获取物品的id
	 * @return int 物品id, 全Context唯一
	 */
	public int getId();
	
	/**
	 * 获取物品类型
	 * @return String 物品类型
	 */
	public String getType();
}
