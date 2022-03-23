package io.github.ashr123.exceptional.functions;

import java.util.function.LongBinaryOperator;

@FunctionalInterface
public interface ThrowingLongBinaryOperator extends LongBinaryOperator
{
	static LongBinaryOperator unchecked(ThrowingLongBinaryOperator throwingLongBinaryOperator)
	{
		return throwingLongBinaryOperator;
	}

	@Override
	default long applyAsLong(long left, long right)
	{
		try
		{
			return applyAsLongThrows(left, right);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	long applyAsLongThrows(long left, long right) throws Exception;
}