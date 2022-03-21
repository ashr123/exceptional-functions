package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleToIntFunction;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction extends DoubleToIntFunction
{
	static DoubleToIntFunction unchecked(ThrowingDoubleToIntFunction throwingDoubleToIntFunction)
	{
		return throwingDoubleToIntFunction;
	}

	@Override
	default int applyAsInt(double value)
	{
		try
		{
			return applyAsIntThrows(value);
		} catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
	}

	int applyAsIntThrows(double value) throws Exception;
}