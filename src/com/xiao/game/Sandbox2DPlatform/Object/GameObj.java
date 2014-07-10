package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Data.Point;

public interface GameObj
{
	public Point getCenterPoint();
	public MapCoordinate getMapCoordinate();
	public int getId();
}
