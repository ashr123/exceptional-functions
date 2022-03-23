package io.github.ashr123.exceptional.functions;

import java.util.function.DoublePredicate;

@FunctionalInterface
public interface ThrowingDoublePredicate extends DoublePredicate
{
	static DoublePredicate unchecked(ThrowingDoublePredicate throwingDoublePredicate)
	{
		return throwingDoublePredicate;
	}

	@Override
	default boolean test(double value)
	{
		try
		{
			return testThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	boolean testThrows(double value) throws Exception;
}