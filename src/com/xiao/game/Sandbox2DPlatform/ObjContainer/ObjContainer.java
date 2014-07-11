package com.xiao.game.Sandbox2DPlatform.ObjContainer;

import com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public interface ObjContainer extends Iterable<GameObj>
{
	public GameObj getObjById(int id);
	public void setFilter(ObjFilter filter);
	public int size();
}
