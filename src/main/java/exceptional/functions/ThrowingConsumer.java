package exceptional.functions;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T>
{
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