package com.xiao.game.Sandbox2DPlatform.Data;

public abstract class MaterialObj implements Material
{
	protected final int id;

	protected MaterialObj(int id)
	{
		this.id = id;
	}

	@Override
	public int getId()
	{
		return id;
	}

}
