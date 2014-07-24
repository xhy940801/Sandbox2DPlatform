package com.xiao.game.Sandworm.Stream;

/**
 * if the end of the stream is reached. it will be throw
 * @author xiao.hy
 * @see java.lang.Exception
 */
public class EndOfStreamException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EndOfStreamException()
	{
	}

	public EndOfStreamException(String message)
	{
		super(message);
	}

	public EndOfStreamException(Throwable cause)
	{
		super(cause);
	}

	public EndOfStreamException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public EndOfStreamException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
