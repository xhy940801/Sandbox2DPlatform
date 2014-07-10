package com.xiao.game.Sandbox2DPlatform.Data;

public class IRect
{
	private int left, top;
	private int right, bottom;

	public int getLeft()
	{
		return left;
	}

	public void setLeft(int left)
	{
		this.left = left;
	}

	public int getTop()
	{
		return top;
	}

	public void setTop(int top)
	{
		this.top = top;
	}

	public int getRight()
	{
		return right;
	}

	public void setRight(int right)
	{
		this.right = right;
	}

	public int getBottom()
	{
		return bottom;
	}

	public void setBottom(int bottom)
	{
		this.bottom = bottom;
	}

	public MapCoordinate getLeftTop()
	{
		return new MapCoordinate(left, top);
	}

	public void setLeftTop(MapCoordinate lt)
	{
		this.left = lt.x;
		this.top = lt.y;
	}

	public void setLeftTop(int left, int top)
	{
		this.left = left;
		this.top = top;
	}

	public MapCoordinate getRightBottom()
	{
		return new MapCoordinate(right, bottom);
	}

	public void setRightBottom(MapCoordinate rightBottom)
	{
		this.right = rightBottom.x;
		this.bottom = rightBottom.y;
	}

	public void setRightBottom(int right, int bottom)
	{
		this.right = right;
		this.bottom = bottom;
	}

	public void set(int left, int top, int right, int bottom)
	{
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	public void set(MapCoordinate leftTop, MapCoordinate rightBottom)
	{
		this.left = leftTop.x;
		this.top = leftTop.y;
		this.right = rightBottom.x;
		this.bottom = rightBottom.y;
	}
}
