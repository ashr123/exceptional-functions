package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleSupplier;

@FunctionalInterface
public interface ThrowingDoubleSupplier extends DoubleSupplier
{
	@Override
	default double getAsDouble()
	{
		try
		{
			return getAsDoubleThrows();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	double getAsDoubleThrows() throws Exception;
}