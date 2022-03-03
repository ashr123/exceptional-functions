package io.github.ashr123.exceptional.functions;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface ThrowingBiPredicate<T, U> extends BiPredicate<T, U>
{
	@Override
	default boolean test(T t, U u)
	{
		try
		{
			return testThrows(t, u);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Evaluates this predicate on the given arguments.
	 *
	 * @param t the first input argument
	 * @param u the second input argument
	 * @return {@code true} if the input arguments match the predicate,
	 * otherwise {@code false}
	 */
	boolean testThrows(T t, U u) throws Exception;
}