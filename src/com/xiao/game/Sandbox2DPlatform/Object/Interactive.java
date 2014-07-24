package com.xiao.game.Sandbox2DPlatform.Object;

import com.xiao.game.Sandbox2DPlatform.Message.ReturnData;

/**
 * 可响应物体
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.GameObj
 */
public interface Interactive extends GameObj
{
	static public final int IGNORE = 0;
	static public final int TRANSFER = 1;
	static public final int CONSUME = -1;
	
	/**
	 * Function-Type: CallBack
	 * @param senderObj GameObj The message sender
	 * @param senderString[] TypeDetail the type of message sender
	 * @param msgCode message code
	 * @param msg detail message
	 * @return A integer value.
	 * 		if(@return == TRANSFER) the message has been dispose and it will transfer to next interactive object.
	 * 		if(@return == IGNORE) the function ignore the message.
	 * 		if(@return == CONSUME) the function dispose and consume the message.
	 */
	public int responseMessage(GameObj senderObj, String[] senderTypeDetail, int msgCode, Object msg, ReturnData returnData);
}
