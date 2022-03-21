package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleUnaryOperator;

@FunctionalInterface
public interface ThrowingDoubleUnaryOperator extends DoubleUnaryOperator
{
	static DoubleUnaryOperator unchecked(ThrowingDoubleUnaryOperator throwingDoubleUnaryOperator)
	{
		return throwingDoubleUnaryOperator;
	}

	@Override
	default double applyAsDouble(double operand)
	{
		try
		{
			return applyAsDoubleThrows(operand);
		} catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
	}

	double applyAsDoubleThrows(double operand) throws Exception;
}