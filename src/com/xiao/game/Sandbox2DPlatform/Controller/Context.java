package com.xiao.game.Sandbox2DPlatform.Controller;

import com.xiao.game.Sandbox2DPlatform.Message.MessageCallBackRegister;
import com.xiao.game.Sandbox2DPlatform.Message.MessageDispenser;

/**
 * 上下文接口
 * @author xiao.hy
 */
public interface Context
{
	/**
	 * 获取信息发送器
	 * @return MessageDispenser 信息发送器
	 */
	public MessageDispenser getMessageDispenser();
	
	/**
	 * 获取物体保存器的管理器
	 * @return ObjContainerManager 物品保存器的管理器
	 */
	public ObjContainerManager getObjContainerManager();
	
	/**
	 * 获取消息回调注册器
	 * @return MessageCallBackRegister 消息回调注册器
	 */
	public MessageCallBackRegister getMessageCallBackRegister();
	
	/**
	 * 暂停,并且由其他执行器接管
	 * @param exe Executable 接管的执行器
	 * @see com.xiao.game.Sandbox2DPlatform.Controller.Executable
	 */
	public void pause(Executable exe);
	
	/**
	 * 回复为原本的本执行器执行
	 */
	public void resume();
}
