package com.xiao.game.Sandbox2DPlatform.ObjContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;
import com.xiao.game.Sandbox2DPlatform.Object.StaticObj;

/**
 * 静态物品容器类
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjContainer.ObjContainer
 */
public class StaticObjContainer implements ObjContainer
{
	private final int width, height;
	private int length;
	private Filter<GameObj> filter;
	private StaticObj[] objs;
	private Map<Integer, StaticObj> mObjs;

	/**
	 * 构造器
	 * @param width int 地图的宽度
	 * @param height int 地图的高度
	 */
	public StaticObjContainer(int width, int height)
	{
		this.width = width;
		this.height = height;
		length = 0;
		objs = new StaticObj[width * height];
		mObjs = new HashMap<Integer, StaticObj>();
	}

	@Override
	public Iterator<GameObj> iterator()
	{
		return new ContainerIterator();
	}

	@Override
	public StaticObj getObjById(int id)
	{
		return mObjs.get(id);
	}

	@Override
	public void setFilter(Filter<GameObj> filter)
	{
		this.filter = filter;
	}

	@Override
	public int size()
	{
		return length;
	}
	
	/**
	 * 通过地图坐标获取静态物品
	 * @param x int 地图x坐标
	 * @param y int 地图y坐标
	 * @return StaticObj 静态物品
	 */
	public StaticObj getObjByCoordinate(int x, int y)
	{
		return objs[y * width + x];
	}
	
	/**
	 * 通过地图坐标获取静态物品
	 * @param mc MapCoordinate 地图坐标
	 * @return 静态物品
	 */
	public StaticObj getObjByCoordinate(MapCoordinate mc)
	{
		return objs[mc.getY() * width + mc.getX()];
	}
	
	/**
	 * 在给定的地图坐标设置静态物品
	 * @param x int 地图x坐标
	 * @param y int 地图y坐标
	 * @param obj StaticObj 要设置的静态物品
	 */
	protected void setObjByCoordinate(int x, int y, StaticObj obj)
	{
		objs[y * width + x] = obj;
	}
	
	/**
	 * 在给定的地图坐标设置静态物品
	 * @param mc MapCoordinate 地图坐标
	 * @param obj StaticObj 要设置的静态物品
	 */
	protected void setObjByCoordinate(MapCoordinate mc, StaticObj obj)
	{
		objs[mc.getY() * width + mc.getX()] = obj;
	}
	
	/**
	 * 将物品放入静态地图
	 * @param gObj 要放入的静态物品
	 */
	public void put(StaticObj gObj)
	{
		GameObj obj = this.getObjByCoordinate(gObj.getMapCoordinate());
		this.setObjByCoordinate(gObj.getMapCoordinate(), gObj);
		mObjs.put(gObj.getId(), gObj);
		if(obj != null)
			mObjs.remove(obj.getId());
	}

	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * 迭代器内部类
	 * @author xiao.hy
	 * @see java.util.Iterator
	 */
	private class ContainerIterator implements Iterator<GameObj>
	{
		private Iterator<StaticObj> it;
		private StaticObj curObj;
		
		/**
		 * 构造器,初始化
		 */
		public ContainerIterator()
		{
			it = mObjs.values().iterator();
			while(it.hasNext() && !filter.isPass(curObj = it.next()));
		}

		@Override
		public boolean hasNext()
		{
			return it.hasNext();
		}

		@Override
		public StaticObj next()
		{
			StaticObj gObj = curObj;
			while(it.hasNext() && !filter.isPass(curObj = it.next()));
			return gObj;
		}

		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("this Iterator of ObjContainer is not support the operator : remove");
		}
		
	}

}
