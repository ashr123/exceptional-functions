package io.github.ashr123.exceptional.functions;

import java.util.function.IntBinaryOperator;

@FunctionalInterface
public interface ThrowingIntBinaryOperator extends IntBinaryOperator
{
	static IntBinaryOperator unchecked(ThrowingIntBinaryOperator throwingIntBinaryOperator)
	{
		return throwingIntBinaryOperator;
	}

	@Override
	default int applyAsInt(int left, int right)
	{
		try
		{
			return applyAsIntThrows(left, right);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int applyAsIntThrows(int left, int right) throws Exception;
}