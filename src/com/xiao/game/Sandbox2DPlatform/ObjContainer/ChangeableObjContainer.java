package com.xiao.game.Sandbox2DPlatform.ObjContainer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.GameObjFilter.GameBlankFilter;
import com.xiao.game.Sandbox2DPlatform.Object.Changeable;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * ChangeableObj的容器
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjContainer.ObjContainer
 */
public class ChangeableObjContainer implements ObjContainer
{
	Map<Integer, Changeable> objs;
	Filter<GameObj> filter;

	/**
	 * 构造器,初始化各参数
	 */
	public ChangeableObjContainer()
	{
		objs = new HashMap<Integer, Changeable>();
		filter = GameBlankFilter.getBlankFilter();
	}

	@Override
	public Iterator<GameObj> iterator()
	{
		return new ContainerIterator();
	}

	@Override
	public Changeable getObjById(int id)
	{
		return objs.get(id);
	}

	@Override
	public void setFilter(Filter<GameObj> filter)
	{
		this.filter = filter;
	}

	@Override
	public int size()
	{
		return objs.size();
	}
	
	/**
	 * 增加物品
	 * @param gObj Changeable 要增加的物品
	 */
	public void add(Changeable gObj)
	{
		objs.put(gObj.getId(), gObj);
	}
	
	/**
	 * 删除物品
	 * @param id int 要删除的物品id
	 * @return Changeable 被删除的物品
	 */
	public Changeable remove(int id)
	{
		return objs.remove(id);
	}
	
	/**
	 * 删除物品
	 * @param gObj Changeable 要删除的物品
	 * @return Changeable 被删除的物品
	 */
	public Changeable remove(Changeable gObj)
	{
		return objs.remove(gObj.getId());
	}
	
	/**
	 * 迭代器类
	 * @author xiao.hy
	 * @see java.util.Iterator
	 */
	private class ContainerIterator implements Iterator<GameObj>
	{
		private Iterator<Changeable> it;
		private Changeable curObj;
		
		/**
		 * 构造器
		 */
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
		public Changeable next()
		{
			Changeable gObj = curObj;
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
