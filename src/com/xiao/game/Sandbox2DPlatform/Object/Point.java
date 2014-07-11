package com.xiao.game.Sandbox2DPlatform.Object;

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

	public double getY()
	{
		return y;
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

}
