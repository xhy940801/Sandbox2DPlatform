package com.xiao.game.Frame2D.Attribute;

/**
 * 属性管理器
 * @author xiao.hy
 * @see com.xiao.game.Frame2D.Attribute.Attribution
 */
public interface AttributionManager
{
	/**
	 * 获取属性
	 * @param attrName String 属性名, 全Manager唯一
	 * @return Attribution 属性
	 */
	public Attribution getAttribution(String attrName);
}
