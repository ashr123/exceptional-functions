package io.github.ashr123.exceptional.functions;

import java.util.function.ToLongBiFunction;

@FunctionalInterface
public interface ThrowingToLongBiFunction<T, U> extends ToLongBiFunction<T, U>
{
	static <T, U> ToLongBiFunction<T, U> unchecked(ThrowingToLongBiFunction<T, U> throwingToLongBiFunction)
	{
		return throwingToLongBiFunction;
	}

	@Override
	default long applyAsLong(T t, U u)
	{
		try
		{
			return applyAsLongThrows(t, u);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	long applyAsLongThrows(T t, U u) throws Exception;
}