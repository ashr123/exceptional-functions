package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleBinaryOperator;

@FunctionalInterface
public interface ThrowingDoubleBinaryOperator extends DoubleBinaryOperator
{
	@Override
	default double applyAsDouble(double left, double right)
	{
		try
		{
			return applyAsDoubleThrows(left, right);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	double applyAsDoubleThrows(double left, double right) throws Exception;
}