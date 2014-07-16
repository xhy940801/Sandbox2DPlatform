package com.xiao.Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * 跳表(允许元素重复)
 * @author xiao.hy
 *
 * @param <T>
 */
public class SkipList<T extends Comparable<? super T>> implements Collection<T>
{
	int totalFloor;
	int length;
	private Node bottom;
	private Node top;

	private Random random;

	private final Node blankNode;

	public SkipList()
	{
		blankNode = new Node();
		random = new Random();
		this.init();
	}

	@Override
	public boolean add(T o)
	{
		int k = this.getFloor();
		Node nc, pnc;
		if (k > totalFloor)
		{
			this.newFloor();
			pnc = top;
			k = totalFloor;
		}
		else
		{
			pnc = top;
			for (int tn = totalFloor; k != tn;)
			{
				int cprs = 1;
				if (pnc.next != null && (cprs = pnc.next.data.compareTo(o)) < 0)
					pnc = pnc.next;
				else if (cprs == 0)
				{
					this.addRepetition(o, pnc.next);
					k = 0;
					break;
				}
				else
				{
					pnc = pnc.son;
					--tn;
				}
			}
		}
		nc = blankNode;
		while (k-- != 0)
		{
			while (pnc.next != null && pnc.next.data.compareTo(o) < 0)
				pnc = pnc.next;
			Node pnext = pnc.next;
			nc.son = pnc.next = new Node();
			nc = nc.son;
			nc.next = pnext;
			nc.data = o;
			pnc = pnc.son;
		}
		++length;
		return true;
	}
	
	private void addRepetition(T o, Node p)
	{
		while(p.son != null)
			p = p.son;
		Node pn = p.next;
		p.next = new Node(o, pn);
	}

	private void init()
	{
		bottom = top = new Node();
		length = 0;
		totalFloor = 1;
	}

	private int getFloor()
	{
		int k = 1;
		while (random.nextInt(2) != 0)
			++k;
		return k;
	}

	private void newFloor()
	{
		Node nch = new Node();
		nch.son = top;
		top = nch;
		++totalFloor;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0)
	{
		for (T o : arg0)
			if (!this.add(o))
				return false;
		return true;
	}

	@Override
	public void clear()
	{
		this.init();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object arg0)
	{
		T o;
		try
		{
			o = (T) arg0;
		}
		catch (java.lang.ClassCastException e)
		{
			return false;
		}
		int k = totalFloor;
		Node p = top;
		while (k != 0)
		{
			int cprs = 1;
			if (p.next != null && (cprs = p.next.data.compareTo(o)) < 0)
				p = p.next;
			else if (cprs == 0)
				return true;
			else
			{
				p = p.son;
				--k;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0)
	{
		for (Object o : arg0)
			if (!this.contains(o))
				return false;
		return true;
	}

	@Override
	public boolean isEmpty()
	{
		return length == 0;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new SkipListIterator(bottom);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object arg0)
	{
		T o;
		try
		{
			o = (T) arg0;
		}
		catch (java.lang.ClassCastException e)
		{
			return false;
		}
		Node p = top;
		boolean rs = false;
		while (p != null)
		{
			int cprs = 1;
			if (p.next != null && (cprs = p.next.data.compareTo(o)) < 0)
				p = p.next;
			else if (cprs == 0)
			{
				if(p.next.data.equals(o))
				{
					rs = true;
					p.next = p.next.next;
				}
				p = p.son;
			}
			else
			{
				p = p.son;
			}
		}
		--length;
		return rs;
	}

	@Override
	public boolean removeAll(Collection<?> arg0)
	{
		boolean rs = false;
		for (Object o : arg0)
			if (this.remove(o))
				rs = true;
		return rs;
	}

	@Override
	public boolean retainAll(Collection<?> arg0)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public int size()
	{
		return length;
	}

	@Override
	public Object[] toArray()
	{
		Object[] result = new Object[length];
		Node p = bottom;
		for (int i = 0; i < length; ++i)
		{
			p = p.next;
			result[i] = p.data;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T2> T2[] toArray(T2[] result)
	{
		if (result.length < length)
			result = (T2[]) java.lang.reflect.Array.newInstance(result
					.getClass().getComponentType(), length);
		Node p = bottom;
		for (int i = 0; i < length; ++i)
		{
			p = p.next;
			result[i] = (T2) p.data;
		}
		return (T2[]) result;
	}
	
	/**
	 * 取得当前层数
	 * @return int 当前层数
	 */
	public int getTotalFloor()
	{
		return totalFloor;
	}

	private class Node
	{
		public T data;
		public Node next;
		public Node son;
		
		public Node()
		{
			
		}
		
		@Override
		public String toString()
		{
			return data.toString();
		}
		
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
	}

	private class SkipListIterator implements Iterator<T>
	{
		private Node curNode;

		public SkipListIterator(Node p)
		{
			this.curNode = p;
		}

		@Override
		public boolean hasNext()
		{
			return curNode.next != null;
		}

		@Override
		public T next()
		{
			curNode = curNode.next;
			return curNode.data;
		}
		
		@Override
		public void remove()
		{
			SkipList.this.remove(curNode);
		}

	}
}