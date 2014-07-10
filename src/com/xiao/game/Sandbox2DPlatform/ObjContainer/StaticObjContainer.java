package com.xiao.game.Sandbox2DPlatform.ObjContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.xiao.game.Sandbox2DPlatform.Data.MapCoordinate;
import com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public class StaticObjContainer implements ObjContainer
{
	private final int width, height;
	private int length;
	private ObjFilter filter;
	private GameObj[] objs;
	private Map<Integer, GameObj> mObjs;

	public StaticObjContainer(int width, int height)
	{
		this.width = width;
		this.height = height;
		length = 0;
		objs = new GameObj[width * height];
		mObjs = new HashMap<Integer, GameObj>();
	}

	@Override
	public Iterator<GameObj> iterator()
	{
		return new ContainerIterator();
	}

	@Override
	public GameObj getObjById(int id)
	{
		return mObjs.get(id);
	}

	@Override
	public void setFilter(ObjFilter filter)
	{
		this.filter = filter;
	}

	@Override
	public int size()
	{
		return length;
	}
	
	public GameObj getObjByCoordinate(int x, int y)
	{
		return objs[y * width + x];
	}
	
	public GameObj getObjByCoordinate(MapCoordinate mc)
	{
		return objs[mc.getY() * width + mc.getX()];
	}
	
	protected void setObjByCoordinate(int x, int y, GameObj obj)
	{
		objs[y * width + x] = obj;
	}
	
	protected void setObjByCoordinate(MapCoordinate mc, GameObj obj)
	{
		objs[mc.getY() * width + mc.getX()] = obj;
	}
	
	public void put(GameObj gObj)
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
	
	private class ContainerIterator implements Iterator<GameObj>
	{
		private Iterator<GameObj> it;
		private GameObj curObj;
		
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
		public GameObj next()
		{
			GameObj gObj = curObj;
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
