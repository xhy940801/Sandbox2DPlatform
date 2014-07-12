package com.xiao.game.Frame2D.Algorithm;

import com.xiao.game.Frame2D.Config.MapConfig;
import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Data.Point;

/**
 * 算法类
 * 提供com.xiao.game.Frame2D的公共函数
 * @author xiao.hy
 */
public class Calculator
{
	private Calculator()
	{
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 从世界坐标转换到地图坐标
	 * @param point Point 世界坐标的点
	 * @return MapCoordinate 地图坐标的点
	 */
	static public MapCoordinate toCoordinate(Point point)
	{
		int x = (int)(point.getX() / MapConfig.getMultiple() + 0.5);
		int y = (int)(point.getY() / MapConfig.getMultiple() + 0.5);
		return new MapCoordinate(x, y);
	}
	
	/**
	 * 从世界坐标转换到地图坐标
	 * @param px double 世界坐标的x值
	 * @param py double 世界坐标的y值
	 * @return MapCoordinate 地图坐标的点
	 */
	static public MapCoordinate toCoordinate(double px, double py)
	{
		int x = (int)(px / MapConfig.getMultiple() + 0.5);
		int y = (int)(py / MapConfig.getMultiple() + 0.5);
		return new MapCoordinate(x, y);
	}
	
	/**
	 * 从地图坐标转换到世界坐标
	 * @param coordinate MapCoordinate 地图坐标的点
	 * @return Point 世界坐标的点
	 */
	static public Point toPoint(MapCoordinate coordinate)
	{
		double x = coordinate.getX() * MapConfig.getMultiple();
		double y = coordinate.getY() * MapConfig.getMultiple();
		return new Point(x, y); 
	}
	
	/**
	 * 从地图坐标转换到世界坐标
	 * @param px int 地图坐标的x值
	 * @param py int 地图坐标的y值
	 * @return Point 世界坐标的点
	 */
	static public Point toPoint(int px, int py)
	{
		double x = px * MapConfig.getMultiple();
		double y = py * MapConfig.getMultiple();
		return new Point(x, y); 
	}
	
	/**
	 * 计算在x轴方向上跨越了多少个地图坐标
	 * @param point Point 现在所在的世界坐标
	 * @param dx double x方向上的相对位移
	 * @return int 跨越的地图坐标数
	 */
	static public int overCoordinateX(Point point, double dx)
	{
		return (int) ((point.getX() + dx) / MapConfig.getMultiple() + 0.5) - (int) (point.getX() / MapConfig.getMultiple() + 0.5);
	}
	
	/**
	 * 计算在x轴方向上跨越了多少个地图坐标
	 * @param point Point 现在所在的世界坐标
	 * @param dy double y方向上的相对位移
	 * @return int 跨越的地图坐标数
	 */
	static public int overCoordinateY(Point point, double dy)
	{
		return (int) ((point.getY() + dy) / MapConfig.getMultiple() + 0.5) - (int) (point.getY() / MapConfig.getMultiple() + 0.5);
	}

}
