package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;
import com.xiao.game.Sandbox2DPlatform.Object.Point;

public class AreaFilter extends Filter
{
	private Point minPoint, maxPoint;

	public AreaFilter(Point minPoint, Point maxPoint)
	{
		this.minPoint = new Point(minPoint);
		this.maxPoint = new Point(maxPoint);
	}

	@Override
	public boolean isPass(GameObj gObj)
	{
		Point cPoint = gObj.getCenterPoint();
		return cPoint.getX() > minPoint.getX() && cPoint.getY() > minPoint.getY()
				&& cPoint.getX() < maxPoint.getX() && cPoint.getY() < maxPoint.getY();
	}
	
	@Override
	public ObjFilter and(ObjFilter filter)
	{
		if(filter instanceof AreaFilter)
		{
			AreaFilter af = (AreaFilter) filter;
			double minX = af.minPoint.getX() > this.minPoint.getX() ? af.minPoint.getX() : this.minPoint.getX();
			double minY = af.minPoint.getY() > this.minPoint.getY() ? af.minPoint.getY() : this.minPoint.getY();
			
			double maxX = af.maxPoint.getX() < this.maxPoint.getX() ? af.maxPoint.getX() : this.maxPoint.getX();
			double maxY = af.maxPoint.getY() < this.maxPoint.getY() ? af.maxPoint.getY() : this.maxPoint.getY();
			
			if(minX >= maxX || minY >= maxY)
				return BlankFilter.getBlankFilter();
			else
				return new AreaFilter(new Point(minX, minY), new Point(maxX, maxY));
		}
		else
			return super.and(filter);
	}

}
