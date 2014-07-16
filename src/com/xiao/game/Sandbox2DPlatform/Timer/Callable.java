package com.xiao.game.Sandbox2DPlatform.Timer;

import com.xiao.game.Sandbox2DPlatform.Controller.Context;

/**
 * 回调函数接口
 * @author xiao.hy
 */
public interface Callable
{
	/**
	 * 回调函数
	 * @param data 注册回调函数时传入的data
	 * @param context 游戏上下文
	 */
	public void call(Object data, Context context);
}
