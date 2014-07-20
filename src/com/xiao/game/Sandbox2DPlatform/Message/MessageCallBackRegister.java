package com.xiao.game.Sandbox2DPlatform.Message;

import com.xiao.game.Sandbox2DPlatform.Object.InteractiveObj;

/**
 * 消息回调注册器类
 * 用来注册接受什么类型的消息
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Object.InteractiveObj
 * 		com.xiao.game.Sandbox2DPlatform.Message.MessageDispenser
 */
public interface MessageCallBackRegister
{
	/**
	 * 注册消息监听器
	 * @param gObj InteractiveObj 消息的注册者
	 * @param msgType String[] 接受的消息类型
	 */
	public void register(InteractiveObj gObj, String[] msgType);
	
	/**
	 * 注销消息监听器
	 * @param gObj InteractiveObj 消息的注册者
	 * @param msgType String[] 接受的消息类型
	 * @return boolean 是否存在指定消息
	 */
	public boolean deregister(InteractiveObj gObj, String[] msgType);
	
	/**
	 * 递归注销类型及其子类型下的相同消息监听器
	 * @param gObj InteractiveObj 消息的注册者
	 * @param msgType String[] 接受的消息类型
	 * @return boolean 共注销消息个数
	 */
	public int deregisterRecursion(InteractiveObj gObj, String[] msgType);
}
