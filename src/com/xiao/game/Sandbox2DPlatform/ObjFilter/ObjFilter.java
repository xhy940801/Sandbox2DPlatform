package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public interface ObjFilter
{
	public boolean isPass(GameObj gObj);
	public ObjFilter or(ObjFilter filter);
	public ObjFilter and(ObjFilter filter);
	public void filter(Iterable<GameObj> iter, List<GameObj> list);
}
