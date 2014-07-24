package com.xiao.game.Sandbox2DPlatform.Message;

import java.util.List;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;
import com.xiao.game.Sandbox2DPlatform.Object.Interactive;

/**
 * 消息分发器(广播器)
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Message.MessageCallBackRegister
 */
public interface MessageDispenser
{
	/**
	 * 广播消息
	 * @param senderObj GameObj 发送者的GameObj
	 * @param msgType String[] 发送信息类别
	 * @param msgCode int 消息代码
	 * @param msg Object 详细消息信息
	 * @param returnDatas List<ReturnData> 接收的返回值将放在这个List里面
	 * @return int 总共处理此消息的对象的个数
	 */
	public int boardCastMessage(GameObj senderObj, String[] msgType, int msgCode, Object msg, List<ReturnData> returnDatas);
	
	/**
	 * 广播消息
	 * @param senderObj GameObj 发送者的GameObj
	 * @param msgType String[] 发送信息类别
	 * @param msgCode int 消息代码
	 * @param msg Object 详细消息信息
	 * @param returnDatas List<ReturnData> 接收的返回值将放在这个List里面
	 * @param filter ObjFilter 接收消息者的过滤器,对消息接收者进行过滤
	 * @return int 总共处理此消息的对象的个数
	 */
	public int boardCastMessage(GameObj senderObj, String[] msgType, int msgCode, Object msg, List<ReturnData> returnDatas, Filter<GameObj> filter);
	
	/**
	 * 发送消息给特定人
	 * @param senderObj GameObj 发送者的GameObj
	 * @param msgType String[] 发送信息类别
	 * @param receiverObj Interactive 接受者的GameObj
	 * @param msgCode int 消息代码
	 * @param msg Object 详细消息信息
	 * @param returnData ReturnData 返回的消息
	 * @return boolean 对方是否处理消息
	 */
	public boolean sendMessage(GameObj senderObj, String[] msgType, Interactive receiverObj, int msgCode, Object msg, ReturnData returnData);
}
