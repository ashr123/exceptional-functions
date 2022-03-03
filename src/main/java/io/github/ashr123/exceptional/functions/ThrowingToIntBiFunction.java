package io.github.ashr123.exceptional.functions;

import java.util.function.ToIntBiFunction;

@FunctionalInterface
public interface ThrowingToIntBiFunction<T, U> extends ToIntBiFunction<T, U>
{
	@Override
	default int applyAsInt(T t, U u)
	{
		try
		{
			return applyAsIntThrows(t, u);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int applyAsIntThrows(T t, U u) throws Exception;
}