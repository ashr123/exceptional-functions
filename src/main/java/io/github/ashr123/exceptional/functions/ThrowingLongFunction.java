package io.github.ashr123.exceptional.functions;

import java.util.function.LongFunction;

@FunctionalInterface
public interface ThrowingLongFunction<R> extends LongFunction<R>
{
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