package io.github.ashr123.exceptional.functions;

import java.util.function.IntToDoubleFunction;

@FunctionalInterface
public interface ThrowingIntToDoubleFunction extends IntToDoubleFunction
{
	@Override
	default double applyAsDouble(int value)
	{
		try
		{
			return applyAsDoubleThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	double applyAsDoubleThrows(int value) throws Exception;
}