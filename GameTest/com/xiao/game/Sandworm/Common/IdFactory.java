package com.xiao.game.Sandworm.Common;

/**
 * id工厂
 * @author xiao.hy
 */
public class IdFactory
{
	static private int curGameObjId = 0;
	
	/**
	 * 获取GameObj的id
	 * @return int id
	 */
	static public int getGameObjId()
	{
		return curGameObjId++;
	}
}
