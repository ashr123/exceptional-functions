package io.github.ashr123.exceptional.functions;

import java.util.function.IntUnaryOperator;

@FunctionalInterface
public interface ThrowingIntUnaryOperator extends IntUnaryOperator
{
	static IntUnaryOperator unchecked(ThrowingIntUnaryOperator throwingIntUnaryOperator)
	{
		return throwingIntUnaryOperator;
	}

	@Override
	default int applyAsInt(int operand)
	{
		try
		{
			return applyAsIntThrows(operand);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	int applyAsIntThrows(int operand) throws Exception;
}