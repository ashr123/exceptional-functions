package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleToIntFunction;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction extends DoubleToIntFunction
{
	@Override
	default int applyAsInt(double value)
	{
		try
		{
			return applyAsIntThrows(value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	int applyAsIntThrows(double value) throws Exception;
}