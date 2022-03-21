package io.github.ashr123.exceptional.functions;

import java.util.function.IntConsumer;

@FunctionalInterface
public interface ThrowingIntConsumer extends IntConsumer
{
	static IntConsumer unchecked(ThrowingIntConsumer throwingIntConsumer)
	{
		return throwingIntConsumer;
	}

	@Override
	default void accept(int value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(int value) throws Exception;
}