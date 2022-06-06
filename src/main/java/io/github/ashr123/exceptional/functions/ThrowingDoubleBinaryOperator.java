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
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	double applyAsDoubleThrows(double left, double right) throws Exception;
}