package io.github.ashr123.exceptional.functions;

import java.util.function.IntBinaryOperator;

@FunctionalInterface
public interface ThrowingIntBinaryOperator extends IntBinaryOperator
{
	@Override
	default int applyAsInt(int left, int right)
	{
		try
		{
			return applyAsIntThrows(left, right);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	int applyAsIntThrows(int left, int right) throws Exception;
}