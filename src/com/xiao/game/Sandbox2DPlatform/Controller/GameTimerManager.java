package com.xiao.game.Sandbox2DPlatform.Controller;

import java.util.Iterator;

import com.xiao.Collections.SkipList;
import com.xiao.game.Sandbox2DPlatform.Timer.Callable;

/**
 * 游戏定时器管理器类
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Timer.Callable
 */
public class GameTimerManager
{
	private SkipList<Timer> timerList;
	
	/**
	 * 构造函数
	 */
	public GameTimerManager()
	{
		timerList = new SkipList<Timer>();
	}
	
	/**
	 * 增加定时器
	 * 程序将在delay毫秒后回调, 并传回data
	 * @param delay int 等待时间(毫秒)
	 * @param ca Callable 回调函数
	 * @param data Object 要传递的数据
	 */
	public void addCallback(int delay, Callable ca, Object data)
	{
		Timer t = new Timer(System.currentTimeMillis() + delay, ca, data);
		timerList.add(t);
	}
	
	/**
	 * 增加定时器
	 * 程序将在系统时间为time后回调, 并传回data
	 * @param time long 回调的时间
	 * @param ca Callable 回调函数
	 * @param data Object 要传递的数据
	 */
	public void addCallback(long time, Callable ca, Object data)
	{
		Timer t = new Timer(time, ca, data);
		timerList.add(t);
	}
	
	/**
	 * 运行下一帧
	 * @param millisecond int 上一个tick到这个tick的间隔时间,单位: 毫秒;
	 * @param context Context 游戏的上下文
	 */
	public void nextTick(int millisecond, Context context)
	{
		long curTime = System.currentTimeMillis();
		Iterator<Timer> it = timerList.iterator();
		while(it.hasNext())
		{
			Timer t = it.next();
			if(t.time < curTime)
				break;
			else
			{
				t.callable.call(t.data, context);
				it.remove();
			}
		}
		if(timerList.getTotalFloor() > 10 && timerList.size() == 0)
			timerList.clear();
	}
	
	/**
	 * 定时器内部类
	 * @author xiao.hy
	 * @see java.lang.Comparable
	 */
	private class Timer implements Comparable<Timer>
	{
		Object data;
		long time;
		Callable callable;
		
		/**
		 * 构造函数
		 * @param time long 时间
		 * @param callable Callable 回调函数
		 * @param data Object 数据
		 */
		public Timer(long time, Callable callable,Object data)
		{
			this.data = data;
			this.callable = callable;
			this.time = time;
		}
		
		@Override
		public int compareTo(Timer t)
		{
			return (int) (t.time - this.time);
		}
	}
}
