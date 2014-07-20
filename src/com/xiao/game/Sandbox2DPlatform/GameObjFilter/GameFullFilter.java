package com.xiao.game.Sandbox2DPlatform.GameObjFilter;

import com.xiao.game.Sandbox2DPlatform.Filter.Filter;
import com.xiao.game.Sandbox2DPlatform.Filter.FullFilter;
import com.xiao.game.Sandbox2DPlatform.Object.GameObj;

/**
 * 带工厂的FullFilter<GameObj>
 * @author xiao.hy
 * @see com.xiao.game.Sandbox2DPlatform.Filter.FullFilter
 * 		com.xiao.game.Sandbox2DPlatform.Object.GameObj
 */
public class GameFullFilter extends FullFilter<GameObj>
{
	static private final GameFullFilter fullFilter = new GameFullFilter();
	
	/**
	 * GameFullFilter的静态工厂
	 * @return GameFullFilter GameFullFilter对象
	 */
	static public GameFullFilter getFullFilter()
	{
		return fullFilter;
	}
	
	private GameFullFilter()
	{
		
	}
	
	@Override
	public Filter<GameObj> not()
	{
		return GameBlankFilter.getBlankFilter();
	}
}
