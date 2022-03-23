package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleConsumer;

@FunctionalInterface
public interface ThrowingDoubleConsumer extends DoubleConsumer
{
	static DoubleConsumer unchecked(ThrowingDoubleConsumer throwingDoubleConsumer)
	{
		return throwingDoubleConsumer;
	}

	@Override
	default void accept(double value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	void acceptThrows(double value) throws Exception;
}