package com.xiao.game.Sandworm.Stream;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringBlockReader extends Reader
{
	private Reader reader;
	private Lock lock;
	
	private int radix;

	/**
	 * Controller of the class.
	 * @param reader a Reader
	 */
	public StringBlockReader(Reader reader)
	{
		this.reader = reader;
		lock = new ReentrantLock();
		setRadix(10);
	}
	
	/**
	 * Just call Short.parseShort(readBlock(), radix). Param radix can call setRadix() and getRadix() to set or get.
	 * @return a parseShort value
	 * @throws NumberFormatException if the string does not contain a parsable short
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public short getShort() throws NumberFormatException, IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return Short.parseShort(str, radix);
	}
	
	/**
	 * Just call Integer.parseInt(readBlock(), radix). Param radix can call setRadix() and getRadix() to set or get.
	 * @return a int value
	 * @throws NumberFormatException if the string does not contain a parsable int
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public int getInt() throws NumberFormatException, IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return Integer.parseInt(str, radix);
	}
	
	/**
	 * Just call Long.parseLong(readBlock(), radix). Param radix can call setRadix() and getRadix() to set or get.
	 * @return a long value
	 * @throws NumberFormatException if the string does not contain a parsable long
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public long getLong() throws NumberFormatException, IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return Long.parseLong(str, radix);
	}
	
	/**
	 * Just call Float.parseFloat(readBlock()).
	 * @return a float value
	 * @throws NumberFormatException if the string does not contain a parsable float
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public float getFloat() throws NumberFormatException, IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return Float.parseFloat(str);
	}
	
	/**
	 * Just call Double.parseDouble(readBlock)).
	 * @return a double value
	 * @throws NumberFormatException if the string does not contain a parsable double
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public double getDouble() throws NumberFormatException, IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return Double.parseDouble(str);
	}
	
	/**
	 * Just call Boolean.parseBoolean(readBlock()).
	 * @return a boolean value
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public boolean getBoolean() throws IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return Boolean.parseBoolean(str);
	}
	
	/**
	 * Just call readBlock().
	 * @return a complete String without blank character
	 * @throws IOException If an I/O error occurs
	 * @throws EndOfStreamException if the end of the stream is reached.
	 */
	public String getString() throws IOException, EndOfStreamException
	{
		String str = this.readBlock();
		if(str == null)
			throw new EndOfStreamException();
		return str;
	}

	/**
	 * Read a String block from Reader.
	 * The function will read a complete String without blank character .
	 * @return a complete String without blank character or null if the end of the stream has been reached
	 * @throws IOException If an I/O error occurs
	 */
	public String readBlock() throws IOException
	{
		StringBuffer sb = new StringBuffer();
		lock.lock();
		try
		{
			int c;
			while(true)
			{
				c = reader.read();
				if(c == ' ' || c == '\n' || c == '\r' || c == '\t')
					continue;
				else if(c == -1)
					return null;
				else
					break;
			}
			do
			{
				sb.append((char)c);
				c = reader.read();
			}
			while(c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != -1);
			return sb.toString();
		}
		finally
		{
			lock.unlock();
		}
	}
	
	@Override
	public int read() throws IOException
	{
		lock.lock();
		try
		{
			return reader.read();
		}
		finally
		{
			lock.unlock();
		}
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		lock.lock();
		try
		{
			return reader.read(cbuf, off, len);
		}
		finally
		{
			lock.unlock();
		}
	}

	@Override
	public void close() throws IOException
	{
		lock.lock();
		try
		{
			reader.close();
		}
		finally
		{
			lock.unlock();
		}
	}

	@Override
	public boolean ready() throws IOException
	{
		return reader.ready();
	}

	@Override
	public boolean markSupported()
	{
		return reader.markSupported();
	}

	@Override
	public void mark(int readAheadLimit) throws IOException
	{
		lock.lock();
		try
		{
			reader.mark(readAheadLimit);
		}
		finally
		{
			lock.unlock();
		}
	}

	@Override
	public void reset() throws IOException
	{
		lock.lock();
		try
		{
			reader.reset();
		}
		finally
		{
			lock.unlock();
		}
	}

	/**
	 * Get radix the getShort(), getInt() and getLong() used.
	 * @return the radix
	 */
	public int getRadix()
	{
		return radix;
	}

	/**
	 * Set radix the getShort(), getInt() and getLong() used.
	 * @param radix the radix
	 */
	public void setRadix(int radix)
	{
		this.radix = radix;
	}

}
