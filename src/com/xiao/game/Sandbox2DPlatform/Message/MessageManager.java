package com.xiao.game.Sandbox2DPlatform.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.GameObjFilter.GameBlankFilter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;
import com.xiao.game.Sandbox2DPlatform.Object.Interactive;

public class MessageManager implements MessageCallBackRegister, MessageDispenser
{
	private Node headNode = new Node();
	
	private ReturnData returnData = new ReturnData();

	@Override
	public int boardCastMessage(GameObj senderObj, String[] msgType, int msgCode, Object msg, List<ReturnData> returnDatas)
	{
		return this.boardCastMessage(senderObj, msgType, msgCode, msg, returnDatas, GameBlankFilter.getBlankFilter());
	}

	@Override
	public int boardCastMessage(GameObj senderObj, String[] msgType, int msgCode, Object msg, List<ReturnData> returnDatas, Filter<GameObj> filter)
	{
		if(returnDatas == null)
			return this.bcMsgWithoutRd(senderObj, msgType, msgCode, msg, filter);
		return this.bcMsgWithRd(senderObj, msgType, msgCode, msg, returnDatas, filter);
	}
	
	private int bcMsgWithRd(GameObj senderObj, String[] msgType, int msgCode, Object msg, List<ReturnData> returnDatas, Filter<GameObj> filter)
	{
		Node curNode = headNode;
		int count = 0;
		for(String subType : msgType)
		{
			if(curNode.interactiveObjs != null)
				for(Interactive gObj : curNode.interactiveObjs)
				{
					if(!filter.isPass(gObj))
						continue;
					int res = gObj.responseMessage(senderObj, msgType, msgCode, msg, returnData);
					if(res == Interactive.IGNORE)
						continue;
					if(returnData.getReturnCode() != ReturnData.NONE_DATA)
					{
						returnData.setObj(gObj);
						returnDatas.add(returnData);
						returnData = new ReturnData();
					}
					++count;
					if(res == Interactive.CONSUME)
						return count;
				}
			curNode = curNode.pullNode(subType);
		}
		return count;
	}
	
	private int bcMsgWithoutRd(GameObj senderObj, String[] msgType, int msgCode, Object msg, Filter<GameObj> filter)
	{
		Node curNode = headNode;
		int count = 0;
		for(String subType : msgType)
		{
			if(curNode.interactiveObjs != null)
				for(Interactive gObj : curNode.interactiveObjs)
				{
					if(!filter.isPass(gObj))
						continue;
					int res = gObj.responseMessage(senderObj, msgType, msgCode, msg, returnData);
					if(res == Interactive.IGNORE)
						continue;
					++count;
					if(res == Interactive.CONSUME)
						return count;
				}
			curNode = curNode.pullNode(subType);
		}
		return count;
	}

	@Override
	public boolean sendMessage(GameObj senderObj, String[] msgType, Interactive receiverObj, int msgCode, Object msg, ReturnData returnData)
	{
		return receiverObj.responseMessage(senderObj, msgType, msgCode, msg, returnData) != Interactive.IGNORE;
	}

	@Override
	public void register(Interactive gObj, String[] msgType)
	{
		Node curNode = headNode;
		for(String subType : msgType)
			curNode = curNode.pullNode(subType);
		curNode.push(gObj);
	}

	@Override
	public boolean deregister(Interactive gObj, String[] msgType)
	{
		Node curNode = headNode;
		for(String subType : msgType)
			curNode = curNode.pullNode(subType);
		return curNode.pull(gObj);
	}
	
	@Override
	public int deregisterRecursion(Interactive gObj, String[] msgType)
	{
		Node curNode = headNode;
		for(String subType : msgType)
			curNode = curNode.pullNode(subType);
		return this.deregister(gObj, curNode);
	}
	
	private int deregister(Interactive gObj, Node node)
	{
		if(node == null)
			return 0;
		int n = 0;
		if(node.sons != null)
			for(Node nds : node.sons.values())
				n += this.deregister(gObj, nds);
		while(node.pull(gObj))
			++n;
		return n;
	}
	
	private class Node
	{
		Map<String, Node> sons = null;
		List<Interactive> interactiveObjs = null;
		
		@SuppressWarnings("unused")
		Node getNode(String nodeName)
		{
			if(sons == null)
				return null;
			return sons.get(nodeName);
		}
		
		void push(Interactive obj)
		{
			if(interactiveObjs == null)
				interactiveObjs = new ArrayList<Interactive>(3);
			interactiveObjs.add(obj);
		}
		
		boolean pull(Interactive obj)
		{
			if(interactiveObjs == null)
				return false;
			return interactiveObjs.remove(obj);
		}
		
		@SuppressWarnings("unused")
		void pushTo(String nodeName, Interactive obj)
		{
			if(sons == null)
				sons = new HashMap<String, Node>();
			Node sonNode;
			if(sons.get(nodeName) == null)
				sons.put(nodeName, sonNode = new Node());
			else
				sonNode = sons.get(nodeName);
			sonNode.push(obj);
		}
		
		Node pullNode(String nodeName)
		{
			if(sons == null)
				sons = new HashMap<String, Node>();
			Node sonNode;
			if(sons.get(nodeName) == null)
				sons.put(nodeName, sonNode = new Node());
			else
				sonNode = sons.get(nodeName);
			return sonNode;
		}
	}

}
