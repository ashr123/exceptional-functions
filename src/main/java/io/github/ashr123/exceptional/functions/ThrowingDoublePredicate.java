package io.github.ashr123.exceptional.functions;

import java.util.function.DoublePredicate;

@FunctionalInterface
public interface ThrowingDoublePredicate extends DoublePredicate
{
	@Override
	default boolean test(double value)
	{
		try
		{
			return testThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	boolean testThrows(double value) throws Exception;
}