package io.github.ashr123.exceptional.functions;

import java.util.function.LongToIntFunction;

@FunctionalInterface
public interface ThrowingLongToIntFunction extends LongToIntFunction
{
	static LongToIntFunction unchecked(ThrowingLongToIntFunction throwingLongToIntFunction)
	{
		return throwingLongToIntFunction;
	}

	@Override
	default int applyAsInt(long value)
	{
		try
		{
			return applyAsIntThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int applyAsIntThrows(long value) throws Exception;
}