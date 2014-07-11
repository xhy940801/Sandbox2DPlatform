package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public abstract class Filter implements ObjFilter
{

	protected Filter()
	{
		
	}

	@Override
	public abstract boolean isPass(GameObj gObj);

	@Override
	public ObjFilter or(ObjFilter filter)
	{
		return new OrFilter(this, filter);
	}

	@Override
	public ObjFilter and(ObjFilter filter)
	{
		return new AndFilter(this, filter);
	}

	@Override
	public void filter(Iterable<GameObj> iter, List<GameObj> list)
	{
		for(GameObj obj : iter)
		{
			if(this.isPass(obj))
				list.add(obj);
		}
	}

}
