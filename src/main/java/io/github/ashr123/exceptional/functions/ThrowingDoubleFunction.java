package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleFunction;

@FunctionalInterface
public interface ThrowingDoubleFunction<R> extends DoubleFunction<R>
{
	@Override
	default R apply(double value)
	{
		try
		{
			return applyThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	R applyThrows(double value) throws Exception;
}