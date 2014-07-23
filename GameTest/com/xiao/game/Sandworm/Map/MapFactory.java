package com.xiao.game.Sandworm.Map;

import com.xiao.game.Sandworm.Common.IdFactory;
import com.xiao.game.Sandworm.DataImporter.DataImporter;
import com.xiao.game.Sandworm.Stream.StringBlockReader;

/**
 * 地图工厂
 * @author xiao.hy
 */
public class MapFactory
{	
	/**
	 * 初始化地图
	 * @param o Object 特征码(根据此特征码加载相应的数据)
	 * @return MapBlock[] 地图数据
	 * @see com.xiao.game.Sandworm.DataImporter.DataImporter
	 */
	static public MapBlock[] initMap(Object o)
	{
		StringBlockReader sbReader = new StringBlockReader(DataImporter.getReader(o));
		int width, height;
		try
		{
			width = sbReader.getInt();
			height = sbReader.getInt();
			int totalNumber = width * height;
			MapBlock mps[] = new MapBlock[totalNumber];
			for(int i = 0; i < totalNumber; ++i)
				mps[i] = new MapBlock(i % width, i / width, IdFactory.getGameObjId(), sbReader.getInt());
			sbReader.close();
			return mps;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return new MapBlock[0];
		}
	}
}
