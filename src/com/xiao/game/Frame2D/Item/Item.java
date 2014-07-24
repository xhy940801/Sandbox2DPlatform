package com.xiao.game.Frame2D.Item;

import com.xiao.game.Sandbox2DPlatform.Data.Material;

/**
 * 物品接口
 * @author xiao.hy
 */
public interface Item extends Material
{	
	/**
	 * 获取物品类型
	 * @return String 物品类型
	 */
	public String getType();
}
