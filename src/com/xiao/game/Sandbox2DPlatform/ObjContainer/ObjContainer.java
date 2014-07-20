package com.xiao.game.Sandbox2DPlatform.ObjContainer;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 物品容器接口
 * @author xiao.hy
 * @see java.lang.Iterable
 */
public interface ObjContainer extends Iterable<GameObj>
{
	/**
	 * 根据物品id获取物品
	 * @param id int 物品id
	 * @return GameObj 物品
	 */
	public GameObj getObjById(int id);
	
	/**
	 * 设置过滤器
	 * 设置过滤器后对ObjContainer的迭代会只迭代出符合过滤器的GameObj
	 * @param filter ObjFilter 过滤器
	 */
	public void setFilter(Filter<GameObj> filter);
	
	/**
	 * 获取容器中拥有元素的总量(不考虑过滤器)
	 * @return int 数量
	 */
	public int size();
}
