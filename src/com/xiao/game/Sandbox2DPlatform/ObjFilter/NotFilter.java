package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * NotFilter
 * '非'过滤器,是过滤器进行 ! 的结果
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.Filter
 */
public class NotFilter extends Filter
{
	private ObjFilter filter;
	
	/**
	 * 构造函数
	 * @param filter 执行非运算的过滤器
	 */
	public NotFilter(ObjFilter filter)
	{
		this.filter = filter;
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		return !filter.isPass(gObj);
	}

	@Override
	public ObjFilter not()
	{
		return filter;
	}

}
