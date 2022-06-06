package io.github.ashr123.exceptional.functions;

import java.util.function.LongPredicate;

@FunctionalInterface
public interface ThrowingLongPredicate extends LongPredicate
{
	@Override
	default boolean test(long value)
	{
		try
		{
			return testThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	boolean testThrows(long value) throws Exception;
}