package com.xiao.game.Sandbox2DPlatform.ObjFilter;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 过滤器的接口
 * @author xiao.hy
 */
public interface ObjFilter
{
	/**
	 * 判断物体能否通过过滤
	 * @param gObj GameObj 要过滤的物体
	 * @return boolean 是否能通过过滤
	 */
	public boolean isPass(GameObj gObj);
	
	/**
	 * 对过滤器进行'或'操作,return (this || filter)
	 * @param filter ObjFilter 进行'或'操作的过滤器
	 * @return ObjFilter 运算后的过滤器
	 */
	public ObjFilter or(ObjFilter filter);
	
	/**
	 * 对过滤器进行'与'操作,return (this && filter)
	 * @param filter ObjFilter 进行'与'操作的过滤器
	 * @return ObjFilter 运算后的过滤器
	 */
	public ObjFilter and(ObjFilter filter);
	
	/**
	 * 对过滤器进行'非'操作,return(!this)
	 * @return ObjFilter 运算后的过滤器
	 */
	public ObjFilter not();
	
	/**
	 * 执行过滤操作
	 * @param iter Iterable<GameObj> 输入的集合的迭代器
	 * @param list List<GameObj> 本函数会将输出的内容放在这个list中
	 */
	public void filter(Iterable<GameObj> iter, List<GameObj> list);
}
