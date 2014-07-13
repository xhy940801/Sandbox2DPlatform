package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import com.xiao.game.Sandbox2DPlatform.Data.Point;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 区域过滤器
 * 对物品是否在一个矩形区域进行过滤
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjFilter.Filter
 */
public class AreaFilter extends Filter
{
	private Point minPoint, maxPoint;

	/**
	 * 构造函数
	 * 过滤器会过滤掉不在minPoint与maxPoint所圈定的矩形区域的物体
	 * @param minPoint Point x, y值相对较小的点,如果以屏幕坐标来说就是左上的点
	 * @param maxPoint Point x, y值相对较大的点,如果以屏幕坐标来说就是右下的点
	 */
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
