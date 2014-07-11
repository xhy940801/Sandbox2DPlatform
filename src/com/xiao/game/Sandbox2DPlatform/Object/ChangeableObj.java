package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Controller.Context;

public interface ChangeableObj extends GameObj
{
	public void nextTick(int millisecond, Context context);
}
