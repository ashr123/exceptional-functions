package io.github.ashr123.exceptional.functions;

import java.util.function.ToDoubleBiFunction;

@FunctionalInterface
public interface ThrowingToDoubleBiFunction<T, U> extends ToDoubleBiFunction<T, U>
{
	static <T, U> ToDoubleBiFunction<T, U> unchecked(ThrowingToDoubleBiFunction<T, U> throwingToDoubleBiFunction)
	{
		return throwingToDoubleBiFunction;
	}

	@Override
	default double applyAsDouble(T t, U u)
	{
		try
		{
			return applyAsDoubleThrows(t, u);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	double applyAsDoubleThrows(T t, U u) throws Exception;
}