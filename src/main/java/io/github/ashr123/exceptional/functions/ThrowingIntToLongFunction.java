package io.github.ashr123.exceptional.functions;

import java.util.function.IntToLongFunction;

@FunctionalInterface
public interface ThrowingIntToLongFunction extends IntToLongFunction
{
	@Override
	default long applyAsLong(int value)
	{
		try
		{
			return applyAsLongThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	long applyAsLongThrows(int value) throws Exception;
}