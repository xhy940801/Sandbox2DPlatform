package com.xiao.game.Sandbox2DPlatform.Filter;

import java.util.List;

/**
 * 过滤器的接口
 * @author xiao.hy
 */
public interface Filter<T>
{
	/**
	 * 判断物体能否通过过滤
	 * @param obj T 要过滤的物体
	 * @return boolean 是否能通过过滤
	 */
	public boolean isPass(T obj);
	
	/**
	 * 执行过滤操作
	 * @param iter Iterable<T> 输入的集合的迭代器
	 * @param list List<T> 本函数会将输出的内容放在这个list中
	 */
	public void filter(Iterable<T> iter, List<T> list);
	
	/**
	 * 对过滤器进行'或'操作,return (this || filter)
	 * @param filter Filter<T> 进行'或'操作的过滤器
	 * @return Filter<T> 运算后的过滤器
	 */
	public Filter<T> or(Filter<T> filter);

	/**
	 * 对过滤器进行'与'操作,return (this && filter)
	 * @param filter Filter<T> 进行'与'操作的过滤器
	 * @return Filter<T> 运算后的过滤器
	 */
	public Filter<T> and(Filter<T> filter);
	
	/**
	 * 对过滤器进行'非'操作,return (!this)
	 * @return Filter<T> 运算后的过滤器
	 */
	public Filter<T> not();
}
