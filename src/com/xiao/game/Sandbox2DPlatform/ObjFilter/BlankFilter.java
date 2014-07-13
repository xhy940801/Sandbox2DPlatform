package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;
/**
 * 空过滤器
 * 不执行任何操作的过滤器
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter
 */
public class BlankFilter implements ObjFilter
{
	private static BlankFilter blkFilter = new BlankFilter();
	
	/**
	 * BlankFilter的静态工厂
	 * @return BlankFilter 空过滤器
	 */
	public static BlankFilter getBlankFilter()
	{
		return blkFilter;
	}

	/**
	 * 私有构造函数
	 */
	private BlankFilter()
	{
		
	}

	@Override
	public ObjFilter or(ObjFilter filter)
	{
		return this;
	}

	@Override
	public ObjFilter and(ObjFilter filter)
	{
		return filter;
	}

	@Override
	public void filter(Iterable<GameObj> iter, List<GameObj> list)
	{
		for(GameObj obj : iter)
			list.add(obj);
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		return true;
	}

	@Override
	public ObjFilter not()
	{
		return FullFilter.getFullFilter();
	}

}
