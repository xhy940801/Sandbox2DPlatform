package com.xiao.game.Sandbox2DPlatform.GameObjFilter;

import com.xiao.game.Sandbox2DPlatform.Algorithm.Calculator;
import com.xiao.game.Sandbox2DPlatform.Data.Point;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 距离过滤器
 * 会过滤掉与给定点的距离超过或等于给定距离的点
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.Filter
 */
public class DistanceFilter extends GameObjFilter
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
