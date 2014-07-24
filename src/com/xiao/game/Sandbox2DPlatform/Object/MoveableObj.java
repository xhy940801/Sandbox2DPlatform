package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Data.MaterialObj;
import com.xiao.game.Sandbox2DPlatform.Data.Point;

/**
 * 可被控制的物体的抽象类
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
 * 		com.xiao.game.Sandbox2DPlatform.Object.Changeable
 */
public abstract class MoveableObj extends MaterialObj implements Changeable
{
	protected Point point;

	/**
	 * 构造函数
	 * @param point Point 当前所在世界坐标
	 * @param id int 物体id
	 */
	public MoveableObj(Point point, int id)
	{
		super(id);
		this.point = new Point(point);
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

}
