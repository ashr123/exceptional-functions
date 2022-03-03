package io.github.ashr123.exceptional.functions;

import java.util.function.ToIntFunction;

@FunctionalInterface
public interface ThrowingToIntFunction<T> extends ToIntFunction<T>
{
	@Override
	default int applyAsInt(T value)
	{
		try
		{
			return applyAsIntThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int applyAsIntThrows(T value) throws Exception;
}