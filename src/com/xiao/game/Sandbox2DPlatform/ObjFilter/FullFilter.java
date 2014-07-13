package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 满过滤器
 * 与BlankFilter相反,过滤掉一切东西
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter
 * 		com.xiao.game.Sandbox2DPlatform.ObjFilter.BlankFilter
 */
public class FullFilter implements ObjFilter
{
	static private FullFilter fullFilter = new FullFilter();
	
	/**
	 * 满过滤器的静态工厂
	 * @return FullFilter 满过滤器
	 */
	static public FullFilter getFullFilter()
	{
		return fullFilter;
	}
	
	/**
	 * 私有构造器
	 */
	private FullFilter()
	{
		
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		return false;
	}

	@Override
	public ObjFilter or(ObjFilter filter)
	{
		return filter;
	}

	@Override
	public ObjFilter and(ObjFilter filter)
	{
		return this;
	}

	@Override
	public ObjFilter not()
	{
		return BlankFilter.getBlankFilter();
	}

	@Override
	public void filter(Iterable<GameObj> iter, List<GameObj> list)
	{
		return;
	}

}
