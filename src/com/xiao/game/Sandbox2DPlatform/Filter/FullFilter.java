package com.xiao.game.Sandbox2DPlatform.Filter;

import java.util.List;

/**
 * 满过滤器
 * 与BlankFilter相反,过滤掉一切东西
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter
 * 		com.xiao.game.Sandbox2DPlatform.ObjFilter.BlankFilter
 */
public class FullFilter<T> implements Filter<T>
{	
	/**
	 * 构造器
	 */
	public FullFilter()
	{
		
	}

	@Override
	public boolean isPass(T gObj)
	{
		return false;
	}

	@Override
	public Filter<T> or(Filter<T> filter)
	{
		return filter;
	}

	@Override
	public Filter<T> and(Filter<T> filter)
	{
		return this;
	}

	@Override
	public Filter<T> not()
	{
		return new BlankFilter<T>();
	}

	@Override
	public void filter(Iterable<T> iter, List<T> list)
	{
		return;
	}

}
