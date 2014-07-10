package com.xiao.game.Sandbox2DPlatform.Algorithm;

import com.xiao.game.Sandbox2DPlatform.Data.Point;

public class Calculator
{
	
	static public double calculateDistance(Point p1, Point p2)
	{
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	private Calculator()
	{
	}
}
