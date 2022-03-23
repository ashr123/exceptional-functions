package io.github.ashr123.exceptional.functions;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface ThrowingIntPredicate extends IntPredicate
{
	@Override
	default boolean test(int value)
	{
		try
		{
			return testThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	boolean testThrows(int value) throws Exception;
}