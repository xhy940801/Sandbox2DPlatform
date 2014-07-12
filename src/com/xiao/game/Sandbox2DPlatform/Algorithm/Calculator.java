package com.xiao.game.Sandbox2DPlatform.Algorithm;

import com.xiao.game.Sandbox2DPlatform.Data.Point;

/**
 * 算法类
 * 提供com.xiao.game.Sandbox2DPlatform的公共函数
 * @author xiao.hy
 */
public class Calculator
{
	/**
	 * 计算两个点的距离
	 * @param p1 Point 点1
	 * @param p2 Point 点2
	 * @return double 距离
	 */
	static public double calculateDistance(Point p1, Point p2)
	{
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	private Calculator()
	{
	}
}
