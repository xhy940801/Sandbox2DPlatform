package com.xiao.game.Sandbox2DPlatform.Message;

import com.xiao.game.Sandbox2DPlatform.Object.InteractiveObj;

public interface MessageCallBackRegister
{
	public void register(InteractiveObj gObj, String msgType);
	public boolean deregister(InteractiveObj gObj, String msgType);
}
