package com.xiao.game.Sandbox2DPlatform.Filter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;

/**
 * 部分过滤器的抽象基类
 * 提供了过滤器的一些方法的实现
 * @author Administrator
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter
 */
public abstract class ObjFilter<T> implements Filter<T>
{

	protected ObjFilter()
	{
		
	}

	@Override
	public abstract boolean isPass(T gObj);

	@Override
	public Filter<T> or(Filter<T> filter)
	{
		return new OrFilter<T>(this, filter);
	}

	@Override
	public Filter<T> and(Filter<T> filter)
	{
		return new AndFilter<T>(this, filter);
	}
	
	@Override
	public Filter<T> not()
	{
		return new NotFilter<T>(this);
	}
	/**
	 * 执行过滤操作
	 * @param iter Iterable<T> 输入的集合的迭代器
	 * @param list List<T> 本函数会将输出的内容放在这个list中
	 */
	@Override
	public void filter(Iterable<T> iter, List<T> list)
	{
		for(T obj : iter)
		{
			if(this.isPass(obj))
				list.add(obj);
		}
	}

}
