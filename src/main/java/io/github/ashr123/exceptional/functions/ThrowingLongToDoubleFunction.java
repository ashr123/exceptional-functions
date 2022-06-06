package io.github.ashr123.exceptional.functions;

import java.util.function.LongToDoubleFunction;

@FunctionalInterface
public interface ThrowingLongToDoubleFunction extends LongToDoubleFunction
{
	@Override
	default double applyAsDouble(long value)
	{
		try
		{
			return applyAsDoubleThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	double applyAsDoubleThrows(long value) throws Exception;
}