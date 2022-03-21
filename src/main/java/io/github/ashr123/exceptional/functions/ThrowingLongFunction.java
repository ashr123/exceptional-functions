package io.github.ashr123.exceptional.functions;

import java.util.function.LongFunction;

@FunctionalInterface
public interface ThrowingLongFunction<R> extends LongFunction<R>
{
	static <R> LongFunction<R> unchecked(ThrowingLongFunction<R> throwingLongFunction)
	{
		return throwingLongFunction;
	}

	@Override
	default R apply(long value)
	{
		try
		{
			return applyThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	R applyThrows(long value) throws Exception;
}