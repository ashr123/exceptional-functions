package io.github.ashr123.exceptional.functions;

import java.util.function.Predicate;

@FunctionalInterface
public interface ThrowingPredicate<T> extends Predicate<T>
{
	static <T> Predicate<T> unchecked(ThrowingPredicate<T> throwingPredicate)
	{
		return throwingPredicate;
	}

	@Override
	default boolean test(T t)
	{
		try
		{
			return testThrows(t);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	boolean testThrows(T t) throws Exception;
}