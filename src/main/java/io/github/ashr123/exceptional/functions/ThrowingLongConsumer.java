package io.github.ashr123.exceptional.functions;

import java.util.function.LongConsumer;

@FunctionalInterface
public interface ThrowingLongConsumer extends LongConsumer
{
	@Override
	default void accept(long value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	void acceptThrows(long value) throws Exception;
}