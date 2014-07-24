package com.xiao.game.Sandbox2DPlatform.Data;

/**
 * 地图坐标类
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Data.Point
 */
public class MapCoordinate
{
	int x, y;
	public MapCoordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public MapCoordinate(MapCoordinate mapCoordinate)
	{
		this.x = mapCoordinate.x;
		this.y = mapCoordinate.y;
	}

	public int getX()
	{
		return x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}

	public void set(int x, int y)
	{
		this.x = x;
		this.y = y;
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
	
	@Override
	public int hashCode()
	{
		return (x + ":" + y).hashCode();
	}
}
