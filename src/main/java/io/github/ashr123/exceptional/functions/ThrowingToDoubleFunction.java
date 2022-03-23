package io.github.ashr123.exceptional.functions;

import java.util.function.ToDoubleFunction;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T> extends ToDoubleFunction<T>
{
	static <T> ToDoubleFunction<T> unchecked(ThrowingToDoubleFunction<T> throwingToDoubleFunction)
	{
		return throwingToDoubleFunction;
	}

	@Override
	default double applyAsDouble(T value)
	{
		try
		{
			return applyAsDoubleThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	double applyAsDoubleThrows(T value) throws Exception;
}