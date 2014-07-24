package com.xiao.game.Frame2D.Player;

import com.xiao.game.Sandbox2DPlatform.Object.Rulable;

/**
 * 玩家接口
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatForm.Object.RulableObj
 *		com.xiao.game.Sandbox2DPlatForm.Object.MoveableObj
 *		com.xiao.game.Frame2D.Player.AttributionOnwer
 */
public interface Player extends Rulable, ItemsOnwer, AttributionOnwer
{
	static public final int PREVENT_MOVE = -1;
}
