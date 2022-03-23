package io.github.ashr123.exceptional.functions;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface ThrowingBiPredicate<T, U> extends BiPredicate<T, U>
{
	static <T, U> BiPredicate<T, U> unchecked(ThrowingBiPredicate<T, U> throwingBiPredicate)
	{
		return throwingBiPredicate;
	}

	@Override
	default boolean test(T t, U u)
	{
		try
		{
			return testThrows(t, u);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	boolean testThrows(T t, U u) throws Exception;
}