package com.xiao.game.Frame2D.Player;

import com.xiao.game.Sandbox2DPlatform.Controller.Context;

/**
 * 操作器借口
 * 操作器是player进行操作的抽象
 * @author xiao.hy
 * @see com.xiao.game.Frame2D.Player.GamePlayer
 */
public interface Operator
{
	/**
	 * 进行相应操作
	 * @param operation Object 具体的操作
	 * @param player GamePlayer 调用者
	 * @param millisecond int 上个tick到这个tick所经过的毫秒数
	 * @param context Context 上下文
	 */
	public void operate(Object operation, GamePlayer player, int millisecond, Context context);
	
	/**
	 * 获取操作码
	 * @return int 操作码
	 * @see Open Declaration com.xiao.game.Frame2D.Config.OperationConfig
	 */
	public int getOperationCode();
}
