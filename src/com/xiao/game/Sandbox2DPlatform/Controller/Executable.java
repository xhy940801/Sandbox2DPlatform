package com.xiao.game.Sandbox2DPlatform.Controller;

/**
 * 执行器类
 * @author xiao.hy
 */
public interface Executable
{
	/**
	 * 运行下一帧
	 * @param millisecond int 上一个tick到这个tick的间隔时间,单位: 毫秒;
	 * @param context Context 游戏的上下文
	 */
	public void nextTick(int millisecond, Context context);
}
