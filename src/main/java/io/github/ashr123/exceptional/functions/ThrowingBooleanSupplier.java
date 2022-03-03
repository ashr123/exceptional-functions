package io.github.ashr123.exceptional.functions;

import java.util.function.BooleanSupplier;

@FunctionalInterface
public interface ThrowingBooleanSupplier extends BooleanSupplier
{
	@Override
	default boolean getAsBoolean()
	{
		try
		{
			return getAsBooleanThrows();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	boolean getAsBooleanThrows() throws Exception;
}