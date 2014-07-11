package com.xiao.game.Sandbox2DPlatform.Controller;

import com.xiao.game.Sandbox2DPlatform.Message.MessageCallBackRegister;
import com.xiao.game.Sandbox2DPlatform.Message.MessageDispenser;

public interface Context
{
	public MessageDispenser getMessageDispenser();
	public ObjContainerManager getObjContainerManager();
	public MessageCallBackRegister getMessageCallBackRegister();
	
	public void pause(Executable exe);
	public void resume();
}
