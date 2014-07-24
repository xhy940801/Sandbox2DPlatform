package com.xiao.game.Sandbox2DPlatform.Filter;

import java.util.List;
/**
 * 空过滤器
 * 不执行任何操作的过滤器
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter
 */
public class BlankFilter<T> implements Filter<T>
{
	/**
	 * 构造函数
	 */
	public BlankFilter()
	{
		
	}

	@Override
	public Filter<T> or(Filter<T> filter)
	{
		return this;
	}

	@Override
	public Filter<T> and(Filter<T> filter)
	{
		return filter;
	}

	@Override
	public void filter(Iterable<T> iter, List<T> list)
	{
		for(T obj : iter)
			list.add(obj);
	}

	@Override
	public boolean isPass(T gObj)
	{
		return true;
	}

	@Override
	public Filter<T> not()
	{
		return new FullFilter<T>();
	}

}
