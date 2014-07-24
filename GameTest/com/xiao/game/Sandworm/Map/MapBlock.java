package com.xiao.game.Sandworm.Map;

import com.xiao.game.Frame2D.Algorithm.Calculator;
import com.xiao.game.Sandbox2DPlatform.Controller.Context;
import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Data.Point;
import com.xiao.game.Sandbox2DPlatform.Object.Static;

/**
 * 游戏地图块类
 * @author xiao.hy
 */
public class MapBlock implements Static
{
	private MapCoordinate mc;
	private final int id;
	private int height;
	
	/**
	 * 构造函数
	 * @param mc MapCoordinate 位置
	 * @param id int 物体id
	 * @param height int 地图块高度
	 */
	public MapBlock(MapCoordinate mc, int id, int height)
	{
		this.mc = new MapCoordinate(mc);
		this.id = id;
		this.height = height;
	}
	
	/**
	 * 构造函数
	 * @param x int 地图x坐标
	 * @param y int 地图y坐标
	 * @param id int 物体id
	 * @param height int 地图块高度
	 */
	public MapBlock(int x, int y, int id, int height)
	{
		this.mc = new MapCoordinate(x, y);
		this.id = id;
		this.height = height;
	}

	@Override
	public Point getCenterPoint()
	{
		return Calculator.toPoint(mc);
	}

	@Override
	public MapCoordinate getMapCoordinate()
	{
		return new MapCoordinate(mc);
	}

	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public int height()
	{
		return height;
	}

	/**
	 * 设置地图块高度
	 * @param height int 高度
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

	@Override
	public boolean init(Context context)
	{
		return true;
	}

	@Override
	public boolean release(Context context)
	{
		return true;
	}

}
