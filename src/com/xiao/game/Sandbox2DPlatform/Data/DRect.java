package com.xiao.game.Sandbox2DPlatform.Data;

public class DRect
{
	private double left, top;
	private double right, bottom;

	public double getLeft()
	{
		return left;
	}

	public void setLeft(double left)
	{
		this.left = left;
	}

	public double getTop()
	{
		return top;
	}

	public void setTop(double top)
	{
		this.top = top;
	}

	public double getRight()
	{
		return right;
	}

	public void setRight(double right)
	{
		this.right = right;
	}

	public double getBottom()
	{
		return bottom;
	}

	public void setBottom(double bottom)
	{
		this.bottom = bottom;
	}

	public Point getLeftTop()
	{
		return new Point(left, top);
	}

	public void setLeftTop(Point lt)
	{
		this.left = lt.x;
		this.top = lt.y;
	}

	public void setLeftTop(double left, double top)
	{
		this.left = left;
		this.top = top;
	}

	public Point getRightBottom()
	{
		return new Point(right, bottom);
	}

	public void setRightBottom(Point rightBottom)
	{
		this.right = rightBottom.x;
		this.bottom = rightBottom.y;
	}

	public void setRightBottom(double right, double bottom)
	{
		this.right = right;
		this.bottom = bottom;
	}

	public void set(double left, double top, double right, double bottom)
	{
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	public void set(Point leftTop, Point rightBottom)
	{
		this.left = leftTop.x;
		this.top = leftTop.y;
		this.right = rightBottom.x;
		this.bottom = rightBottom.y;
	}
}
