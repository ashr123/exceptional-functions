package io.github.ashr123.exceptional.functions;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T>
{
	static <T> Consumer<T> unchecked(ThrowingConsumer<T> throwingConsumer)
	{
		return throwingConsumer;
	}

	@Override
	default void accept(final T t)
	{
		try
		{
			acceptThrows(t);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Performs this operation on the given argument.
	 *
	 * @param t the input argument
	 */
	void acceptThrows(T t) throws Exception;
}