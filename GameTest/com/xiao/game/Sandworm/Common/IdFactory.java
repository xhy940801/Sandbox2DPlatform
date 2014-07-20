package com.xiao.game.Sandworm.Common;

/**
 * id工厂
 * @author xiao.hy
 */
public class IdFactory
{
	static private int curId = 0;
	
	/**
	 * 获取id
	 * @return int id
	 */
	static public int getId()
	{
		return curId++;
	}
}
