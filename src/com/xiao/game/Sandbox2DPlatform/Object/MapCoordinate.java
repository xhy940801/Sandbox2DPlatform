package com.xiao.game.Sandbox2DPlatform.Object;

public class MapCoordinate
{
	int x, y;
	public MapCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof MapCoordinate)
		{
			MapCoordinate mc = (MapCoordinate) o;
			return this.x == mc.x && this.y == mc.y;
		}
		else
			return false;
	}
}
