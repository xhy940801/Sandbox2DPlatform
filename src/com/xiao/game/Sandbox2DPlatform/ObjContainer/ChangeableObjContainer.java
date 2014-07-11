package com.xiao.game.Sandbox2DPlatform.ObjContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.xiao.game.Sandbox2DPlatform.ObjFilter.BlankFilter;
import com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public class ChangeableObjContainer implements ObjContainer
{
	Map<Integer, GameObj> objs;
	ObjFilter filter;

	public ChangeableObjContainer()
	{
		objs = new HashMap<Integer, GameObj>();
		filter = BlankFilter.getBlankFilter();
	}

	@Override
	public Iterator<GameObj> iterator()
	{
		return new ContainerIterator();
	}

	@Override
	public GameObj getObjById(int id)
	{
		return objs.get(id);
	}

	@Override
	public void setFilter(ObjFilter filter)
	{
		this.filter = filter;
	}

	@Override
	public int size()
	{
		return objs.size();
	}
	
	public void add(GameObj gObj)
	{
		objs.put(gObj.getId(), gObj);
	}
	
	public GameObj remove(int id)
	{
		return objs.remove(id);
	}
	
	public GameObj remove(GameObj gObj)
	{
		return objs.remove(gObj.getId());
	}
	
	private class ContainerIterator implements Iterator<GameObj>
	{
		private Iterator<GameObj> it;
		private GameObj curObj;
		
		public ContainerIterator()
		{
			it = objs.values().iterator();
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
