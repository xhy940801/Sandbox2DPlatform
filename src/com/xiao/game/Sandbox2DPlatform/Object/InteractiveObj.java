package com.xiao.game.Sandbox2DPlatform.Object;

public interface InteractiveObj extends GameObj
{
	/**
	 * Function-Type: CallBack
	 * @param senderObjId The id of message sender
	 * @param senderTypeDetail the type of message sender
	 * @param msgCode message code
	 * @param msg detail message
	 * @return A integer value.
	 * 		if(@return > 0) the message has been dispose and it will transfer to next interactive object.
	 * 		if(@return == 0) the function ignore the message.
	 * 		if(@return < 0) the function dispose and consume the message.
	 */
	public int responseMessage(int senderObjId, String senderTypeDetail, int msgCode, Object msg);
}
