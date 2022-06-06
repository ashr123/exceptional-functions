package io.github.ashr123.exceptional.functions;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

@FunctionalInterface
public interface ThrowingSupplier<T> extends Supplier<T>, Callable<T>
{
	static <T> Supplier<T> unchecked(ThrowingSupplier<T> throwingSupplier)
	{
		return throwingSupplier;
	}

	@Override
	default T get()
	{
		try
		{
			return call();
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}
}