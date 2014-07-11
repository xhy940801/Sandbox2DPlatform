package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public class BlankFilter implements ObjFilter
{
	private static BlankFilter blkFilter = new BlankFilter();
	
	public static BlankFilter getBlankFilter()
	{
		return blkFilter;
	}

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

}
