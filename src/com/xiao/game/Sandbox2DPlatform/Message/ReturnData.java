package com.xiao.game.Sandbox2DPlatform.Message;

/**
 * 返回的信息
 * @author xiao.hy
 */
public class ReturnData
{
	private int objId;			//返回者的objId
	private Object data;		//具体返回信息
	private int returnCode;		//返回码
	
	public ReturnData()
	{
		// TODO Auto-generated constructor stub
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

	public int getObjId()
	{
		return objId;
	}

	public void setObjId(int objId)
	{
		this.objId = objId;
	}
}
