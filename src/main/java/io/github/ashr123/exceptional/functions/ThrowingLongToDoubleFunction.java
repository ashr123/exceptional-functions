package io.github.ashr123.exceptional.functions;

import java.util.function.LongToDoubleFunction;

@FunctionalInterface
public interface ThrowingLongToDoubleFunction extends LongToDoubleFunction
{
	static LongToDoubleFunction unchecked(ThrowingLongToDoubleFunction throwingLongToDoubleFunction)
	{
		return throwingLongToDoubleFunction;
	}

	@Override
	default double applyAsDouble(long value)
	{
		try
		{
			return applyAsDoubleThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	double applyAsDoubleThrows(long value) throws Exception;
}