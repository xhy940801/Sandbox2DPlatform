package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * OrFilter
 * '或'过滤器,是两个过滤器进行 || 的结果
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.Filter
 */
public class OrFilter extends Filter
{
	ObjFilter fa, fb;

	/**
	 * 构造函数
	 * @param fa 执行或操作的第一个过滤器
	 * @param fb 执行或操作的第二个过滤器
	 */
	public OrFilter(ObjFilter fa, ObjFilter fb)
	{
		this.fa = fa;
		this.fb = fb;
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		return fa.isPass(gObj) || fb.isPass(gObj);
	}

}
