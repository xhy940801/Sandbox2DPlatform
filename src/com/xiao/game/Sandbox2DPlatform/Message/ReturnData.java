package com.xiao.game.Sandbox2DPlatform.Message;

import com.xiao.game.Sandbox2DPlatform.Object.InteractiveObj;

/**
 * 返回的信息
 * @author xiao.hy
 */
public class ReturnData
{
	static public int NONE_DATA = 0;	//空返回码, 此返回码表示没有返回任何东西
	
	private InteractiveObj obj;			//返回者的objId
	private Object data;		//具体返回信息
	private int returnCode;		//返回码
	
	public ReturnData()
	{
		obj = null;
		data = null;
		returnCode = ReturnData.NONE_DATA;
	}

	public Object getData()
	{
		return data;
	}
	
	public void setData(Object data)
	{
		this.data = data;
	}
	
	public int getReturnCode()
	{
		return returnCode;
	}
	
	public void setReturnCode(int returnCode)
	{
		this.returnCode = returnCode;
	}

	InteractiveObj getObj()
	{
		return obj;
	}

	void setObj(InteractiveObj obj)
	{
		this.obj = obj;
	}
}
