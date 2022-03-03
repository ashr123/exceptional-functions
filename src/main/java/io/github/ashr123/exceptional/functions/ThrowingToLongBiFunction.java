package io.github.ashr123.exceptional.functions;

import java.util.function.ToLongBiFunction;

@FunctionalInterface
public interface ThrowingToLongBiFunction<T, U> extends ToLongBiFunction<T, U>
{
	@Override
	default long applyAsLong(T t, U u)
	{
		try
		{
			return applyAsLongThrows(t, u);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	long applyAsLongThrows(T t, U u) throws Exception;
}