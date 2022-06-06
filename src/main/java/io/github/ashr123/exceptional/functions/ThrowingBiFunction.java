package io.github.ashr123.exceptional.functions;

import java.util.function.BiFunction;

@FunctionalInterface
public interface ThrowingBiFunction<T, U, R> extends BiFunction<T, U, R>
{
	static <T, U, R> BiFunction<T, U, R> unchecked(ThrowingBiFunction<T, U, R> throwingBiFunction)
	{
		return throwingBiFunction;
	}

	@Override
	default R apply(T t, U u)
	{
		try
		{
			return applyThrows(t, u);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	R applyThrows(T t, U u) throws Exception;
}