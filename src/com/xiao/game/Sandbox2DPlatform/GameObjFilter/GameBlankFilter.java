package com.xiao.game.Sandbox2DPlatform.GameObjFilter;

import com.xiao.game.Sandbox2DPlatform.Filter.BlankFilter;
import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 带工厂的BlankFilter<GameObj>
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Filter.BlankFilter
 * 		com.xiao.game.Sandbox2DPlatform.Object.GameObj
 */
public class GameBlankFilter extends BlankFilter<GameObj>
{
	static private final GameBlankFilter blankFilter = new GameBlankFilter();
	
	/**
	 * GameBlankFilter的静态工厂
	 * @return GameBlankFilter GameBlankFilter对象
	 */
	static public GameBlankFilter getBlankFilter()
	{
		return blankFilter;
	}
	
	private GameBlankFilter()
	{
		
	}
	
	@Override
	public Filter<GameObj> not()
	{
		return GameFullFilter.getFullFilter();
	}
}
