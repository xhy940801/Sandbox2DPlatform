package com.xiao.game.Sandbox2DPlatform.Controller;

import com.xiao.game.Sandbox2DPlatform.Message.MessageCallBackRegister;
import com.xiao.game.Sandbox2DPlatform.Message.MessageDispenser;
import com.xiao.game.Sandbox2DPlatform.ObjContainer.ObjContainer;
import com.xiao.game.Sandbox2DPlatform.ObjFilter.BlankFilter;
import com.xiao.game.Sandbox2DPlatform.ObjFilter.DistanceFilter;
import com.xiao.game.Sandbox2DPlatform.ObjFilter.ObjFilter;
import com.xiao.game.Sandbox2DPlatform.Object.ChangeableObj;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

public class MainController implements Context, Executable
{
	private double flushDistance;
	
	private ObjContainerManager objContainerManager;
	private MessageDispenser messageDispenser;
	private MessageCallBackRegister messageCallBackRegister;
	
	private Executable exe;

	public MainController()
	{
		exe = this;
	}
	
	public void nextTick(int millisecond)
	{
		exe.nextTick(millisecond, this);
	}
	
	@Override
	public void nextTick(int millisecond, Context context)
	{
		ObjContainer playerObjContainer = objContainerManager.getPlayerObjContainer();
		ObjFilter filter = BlankFilter.getBlankFilter();
		for(GameObj gObj : playerObjContainer)
			filter = filter.or(new DistanceFilter(gObj.getCenterPoint(), flushDistance));
		
		ObjContainer changeableObjContainer = objContainerManager.getChangeableObjContainer();
		changeableObjContainer.setFilter(filter);
		for(GameObj gObj : changeableObjContainer)
			((ChangeableObj) gObj).nextTick(millisecond, this);
	}

	@Override
	public void pause(Executable exe)
	{
		this.exe = exe;
	}

	@Override
	public void resume()
	{
		this.exe = this;
	}

	@Override
	public MessageDispenser getMessageDispenser()
	{
		return messageDispenser;
	}

	@Override
	public ObjContainerManager getObjContainerManager()
	{
		return objContainerManager;
	}

	@Override
	public MessageCallBackRegister getMessageCallBackRegister()
	{
		return messageCallBackRegister;
	}

	/**
	 * @return the flushDistance
	 */
	public double getFlushDistance()
	{
		return flushDistance;
	}

	/**
	 * @param flushDistance the flushDistance to set
	 */
	public void setFlushDistance(double flushDistance)
	{
		this.flushDistance = flushDistance;
	}

}
