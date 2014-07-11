package com.xiao.game.Sandbox2DPlatform.Message;

import java.util.ArrayList;

import com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter;

public interface MessageDispenser
{
	public int boardCastMessage(int senderObjId, String senderTypeDetail, int msgCode, Object msg, ArrayList<ReturnData> returnDatas);
	public int boardCastMessage(int senderObjId, String senderTypeDetail, int msgCode, Object msg, ArrayList<ReturnData> returnDatas, ObjFilter filter);
	public boolean sendMessage(int senderObjId, String senderTypeDetail, int receiverObjId, int msgCode, Object msg, ReturnData returnData);
}
