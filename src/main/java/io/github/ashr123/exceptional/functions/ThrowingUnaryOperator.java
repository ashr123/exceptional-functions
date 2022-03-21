package io.github.ashr123.exceptional.functions;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ThrowingUnaryOperator<T> extends UnaryOperator<T>
{
	static <T> UnaryOperator<T> unchecked(ThrowingUnaryOperator<T> throwingUnaryOperator)
	{
		return throwingUnaryOperator;
	}

	@Override
	default T apply(T t)
	{
		try
		{
			return applyThrows(t);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	T applyThrows(T t) throws Exception;
}