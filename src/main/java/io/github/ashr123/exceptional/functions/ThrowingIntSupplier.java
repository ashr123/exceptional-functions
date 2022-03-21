package io.github.ashr123.exceptional.functions;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface ThrowingIntSupplier extends IntSupplier
{
	static IntSupplier unchecked(ThrowingIntSupplier throwingIntSupplier)
	{
		return throwingIntSupplier;
	}

	@Override
	default int getAsInt()
	{
		try
		{
			return getAsIntThrows();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int getAsIntThrows() throws Exception;
}