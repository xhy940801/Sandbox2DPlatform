package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public class AndFilter extends Filter
{
	ObjFilter fa, fb;

	public AndFilter(ObjFilter fa, ObjFilter fb)
	{
		this.fa = fa;
		this.fb = fb;
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		return fa.isPass(gObj) && fb.isPass(gObj);
	}

}
