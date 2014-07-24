package com.xiao.game.Sandbox2DPlatform.Data;

import com.xiao.game.Sandbox2DPlatform.Controller.Context;

/**
 * 物质基接口
 * @author xiao.hy
 */
public interface Material
{
	/**
	 * 获取物体的物体id(全Context唯一)
	 * @return int 物体id
	 */
	public int getId();
	
	/**
	 * 初始化, 在context准备完成后回调此函数
	 * @param context Context 上下文
	 * @return boolean 初始化是否成功
	 */
	public boolean init(Context context);
	
	/**
	 * 收尾, 当销毁此对象时调用此函数
	 * @param context Context 上下文
	 * @return boolean 收尾是否成功
	 */
	public boolean release(Context context);
}
