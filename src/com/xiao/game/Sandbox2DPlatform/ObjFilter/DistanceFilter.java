package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import com.xiao.game.Sandbox2DPlatform.Algorithm.Calculator;
import com.xiao.game.Sandbox2DPlatform.Data.Point;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public class DistanceFilter extends Filter
{
	private Point point;
	private double distance;

	public DistanceFilter(Point point, double distance)
	{
		this.point = new Point(point);
		this.distance = distance;
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		Point p = gObj.getCenterPoint();
		return Calculator.calculateDistance(p, point) < distance;
	}

}
