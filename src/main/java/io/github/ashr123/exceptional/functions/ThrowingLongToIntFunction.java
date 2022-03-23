package io.github.ashr123.exceptional.functions;

import java.util.function.LongToIntFunction;

@FunctionalInterface
public interface ThrowingLongToIntFunction extends LongToIntFunction
{
	@Override
	default int applyAsInt(long value)
	{
		try
		{
			return applyAsIntThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	int applyAsIntThrows(long value) throws Exception;
}