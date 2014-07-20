package com.xiao.game.Sandworm.DataImporter;

/**
 * 数据载入接口
 * @author xiao.hy
 */
public interface DataImporter
{
	/**
	 * 根据标识(比如文件名)载入数据
	 * @param feature Object 标识
	 * @return byte[] 数据
	 */
	public byte[] getData(Object feature);
}
