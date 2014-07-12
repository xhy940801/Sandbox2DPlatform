package com.xiao.game.Frame2D.Config;

/**
 * 地图配置
 * 这里定义了地图坐标与世界坐标的转换方式
 * @author xiao.hy
 */
public class MapConfig
{
	
	private MapConfig()
	{
		
	}
	
	static double multiple = 1.0;			//世界坐标与地图坐标的比例
	static double perPieceRadius = 0.5f;	//一个地图方块占世界坐标的长(宽)的一半的值
	
	/**
	 * @return the multiple
	 */
	public static double getMultiple()
	{
		return multiple;
	}
	
	/**
	 * @return the perPieceRadius
	 */
	public static double getPerPieceRadius()
	{
		return perPieceRadius;
	}

}
