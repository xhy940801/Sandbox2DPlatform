package com.xiao.game.Sandbox2DPlatform.Filter;

/**
 * OrFilter
 * '或'过滤器,是两个过滤器进行 || 的结果
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.Filter
 */
public class OrFilter<T> extends ObjFilter<T>
{
	Filter<T> fa, fb;

	/**
	 * 构造函数
	 * @param fa 执行或操作的第一个过滤器
	 * @param fb 执行或操作的第二个过滤器
	 */
	public OrFilter(Filter<T> fa, Filter<T> fb)
	{
		this.fa = fa;
		this.fb = fb;
	}

	@Override
	public boolean isPass(T gObj)
	{
		return fa.isPass(gObj) || fb.isPass(gObj);
	}

}
