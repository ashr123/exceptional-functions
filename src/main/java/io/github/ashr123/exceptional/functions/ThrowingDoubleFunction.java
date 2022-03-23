package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleFunction;

@FunctionalInterface
public interface ThrowingDoubleFunction<R> extends DoubleFunction<R>
{
	static <R> DoubleFunction<R> unchecked(ThrowingDoubleFunction<R> throwingDoubleFunction)
	{
		return throwingDoubleFunction;
	}

	@Override
	default R apply(double value)
	{
		try
		{
			return applyThrows(value);
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	R applyThrows(double value) throws Exception;
}