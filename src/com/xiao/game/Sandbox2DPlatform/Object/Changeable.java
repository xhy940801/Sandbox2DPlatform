package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Controller.Context;

/**
 * 动态物体的接口
 * 会在与程序同步刷新
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
 */
public interface Changeable extends GameObj
{
	/**
	 * 下一帧
	 * @param millisecond int 上一帧与这一帧时间相差的毫秒数
	 * @param context Context 上下文信息
	 */
	public void nextTick(int millisecond, Context context);
}
