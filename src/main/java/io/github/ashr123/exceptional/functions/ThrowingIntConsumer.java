package io.github.ashr123.exceptional.functions;

import java.util.function.IntConsumer;

@FunctionalInterface
public interface ThrowingIntConsumer extends IntConsumer
{
	@Override
	default void accept(int value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	void acceptThrows(int value) throws Exception;
}