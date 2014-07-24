package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Data.Material;
import com.xiao.game.Sandbox2DPlatform.Data.Point;

/**
 * 游戏物体接口
 * 所有游戏物体都必须继承自此类(包括玩家类)
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Data.Material
 */
public interface GameObj extends Material
{
	/**
	 * 获得物品中心点世界坐标
	 * @return Point 世界坐标
	 */
	public Point getCenterPoint();
	
	/**
	 * 获取物品所在的地图坐标
	 * @return MapCoordinate 地图坐标
	 */
	public MapCoordinate getMapCoordinate();
}
