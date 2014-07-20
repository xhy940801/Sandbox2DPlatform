package com.xiao.game.Sandbox2DPlatform.Filter;

/**
 * NotFilter
 * '非'过滤器,是过滤器进行 ! 的结果
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.Filter
 */
public class NotFilter<T> extends ObjFilter<T>
{
	private Filter<T> filter;
	
	/**
	 * 构造函数
	 * @param filter 执行非运算的过滤器
	 */
	public NotFilter(Filter<T> filter)
	{
		this.filter = filter;
	}

	@Override
	public boolean isPass(T obj)
	{
		return !filter.isPass(obj);
	}
	
	@Override
	public Filter<T> not()
	{
		return filter;
	}

}
