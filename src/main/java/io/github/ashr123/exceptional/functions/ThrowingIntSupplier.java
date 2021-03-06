package io.github.ashr123.exceptional.functions;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface ThrowingIntSupplier extends IntSupplier
{
	@Override
	default int getAsInt()
	{
		try
		{
			return getAsIntThrows();
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	int getAsIntThrows() throws Exception;
}