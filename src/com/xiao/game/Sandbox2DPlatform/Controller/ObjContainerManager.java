package com.xiao.game.Sandbox2DPlatform.Controller;

import com.xiao.game.Sandbox2DPlatform.ObjContainer.ObjContainer;
import com.xiao.game.Sandbox2DPlatform.ObjContainer.StaticObjContainer;

/**
 * 物品保存器的管理器
 * 用来管理物品保存器
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.ObjContainer.ObjContainer
 * @see com.xiao.game.Sandbox2DPlatform.ObjContainer.StaticObjContainer
 */
public class ObjContainerManager
{
	private ObjContainer playerObjContainer;
	private ObjContainer changeableObjContainer;
	private StaticObjContainer staticObjContainer;

	public ObjContainerManager()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the player's ObjContainer
	 */
	public ObjContainer getPlayerObjContainer()
	{
		return playerObjContainer;
	}

	/**
	 * @param playerObjContainer the player's ObjContainer to set
	 */
	public void setPlayerObjContainer(ObjContainer playerObjContainer)
	{
		this.playerObjContainer = playerObjContainer;
	}

	/**
	 * @return the ObjContainer of changeable GameObj
	 */
	public ObjContainer getChangeableObjContainer()
	{
		return changeableObjContainer;
	}

	/**
	 * @param changeableObjContainer the ObjContainer of changeable GameObj to set
	 */
	public void setChangeableObjContainer(ObjContainer changeableObjContainer)
	{
		this.changeableObjContainer = changeableObjContainer;
	}

	/**
	 * @return the staticObjContainer
	 */
	public StaticObjContainer getStaticObjContainer()
	{
		return staticObjContainer;
	}

	/**
	 * @param staticObjContainer the staticObjContainer to set
	 */
	public void setStaticObjContainer(StaticObjContainer staticObjContainer)
	{
		this.staticObjContainer = staticObjContainer;
	}
	
}
