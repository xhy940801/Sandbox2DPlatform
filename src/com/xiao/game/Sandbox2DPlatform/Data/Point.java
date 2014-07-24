package com.xiao.game.Sandbox2DPlatform.Data;

/**
 * 世界坐标类
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate
 */
public class Point
{
	double x;
	double y;

	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Point(Point point)
	{
		this.x = point.x;
		this.y = point.y;
	}

	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}

	public void set(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Point)
		{
			Point p = (Point) o;
			return this.x == p.x && this.y == p.y;
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
