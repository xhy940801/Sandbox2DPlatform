package com.xiao.game.Frame2D.Algorithm;

import com.xiao.game.Frame2D.Config.MapConfig;
import com.xiao.game.Sandbox2DPlatform.Object.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Object.Point;

public class Calculator
{
	private Calculator()
	{
		// TODO Auto-generated constructor stub
	}
	
	static public MapCoordinate toCoordinate(Point point)
	{
		int x = (int)(point.getX() / MapConfig.getMultiple() + 0.5);
		int y = (int)(point.getY() / MapConfig.getMultiple() + 0.5);
		return new MapCoordinate(x, y);
	}
	
	static public MapCoordinate toCoordinate(double px, double py)
	{
		int x = (int)(px / MapConfig.getMultiple() + 0.5);
		int y = (int)(py / MapConfig.getMultiple() + 0.5);
		return new MapCoordinate(x, y);
	}
	
	static public Point toPoint(MapCoordinate coordinate)
	{
		double x = coordinate.getX() * MapConfig.getMultiple();
		double y = coordinate.getY() * MapConfig.getMultiple();
		return new Point(x, y); 
	}
	
	static public int overCoordinateX(Point point, double dx)
	{
		return (int) ((point.getX() + dx) / MapConfig.getMultiple() + 0.5) - (int) (point.getX() / MapConfig.getMultiple() + 0.5);
	}
	
	static public int overCoordinateY(Point point, double dy)
	{
		return (int) ((point.getY() + dy) / MapConfig.getMultiple() + 0.5) - (int) (point.getY() / MapConfig.getMultiple() + 0.5);
	}

}
