package io.github.ashr123.exceptional.functions;

import java.util.function.IntUnaryOperator;

@FunctionalInterface
public interface ThrowingIntUnaryOperator extends IntUnaryOperator
{
	@Override
	default int applyAsInt(int operand)
	{
		try
		{
			return applyAsIntThrows(operand);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	int applyAsIntThrows(int operand) throws Exception;
}