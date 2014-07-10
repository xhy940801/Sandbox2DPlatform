package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Data.Point;

public abstract class MoveableObj implements ChangeableObj
{
	protected Point point;
	protected final int id;

	public MoveableObj(Point point, int id)
	{
		this.point = new Point(point);
		this.id = id;
	}

	@Override
	public Point getCenterPoint()
	{
		return point;
	}

	@Override
	public int getId()
	{
		return id;
	}
//	
//	protected void moveTo(double x, double y, int heightMax, int heightMin, Context context)
//	{
//		MapCoordinate mc = this.toCoordinate(x, y);
//		StaticObjContainer sObjContainer = context.getObjContainerManager().getStaticObjContainer();
//		StaticObj sObj = (StaticObj) sObjContainer.getObjByCoordinate(mc);
//		if(heightMax >= sObj.height() && heightMin <= sObj.height())
//			this.setPoint(x, y);
//	}
//	
//	protected abstract MapCoordinate toCoordinate(double x, double y);
//	protected abstract MapCoordinate toCoordinate(Point point);

}
