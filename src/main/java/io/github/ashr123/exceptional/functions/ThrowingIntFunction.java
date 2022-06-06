package io.github.ashr123.exceptional.functions;

import java.util.function.IntFunction;

@FunctionalInterface
public interface ThrowingIntFunction<R> extends IntFunction<R>
{
	static <R> IntFunction<R> unchecked(ThrowingIntFunction<R> throwingIntFunction)
	{
		return throwingIntFunction;
	}

	@Override
	default R apply(int value)
	{
		try
		{
			return applyThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	R applyThrows(int value) throws Exception;
}