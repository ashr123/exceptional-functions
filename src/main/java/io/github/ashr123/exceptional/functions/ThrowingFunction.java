package io.github.ashr123.exceptional.functions;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R>
{
	static <T, R> Function<T, R> unchecked(ThrowingFunction<T, R> throwingFunction)
	{
		return throwingFunction;
	}

	@Override
	default R apply(T t)
	{
		try
		{
			return applyThrows(t);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	R applyThrows(T t) throws Exception;
}