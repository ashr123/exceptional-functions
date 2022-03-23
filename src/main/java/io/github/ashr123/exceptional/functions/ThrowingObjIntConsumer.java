package io.github.ashr123.exceptional.functions;

import java.util.function.ObjIntConsumer;

@FunctionalInterface
public interface ThrowingObjIntConsumer<T> extends ObjIntConsumer<T>
{
	static <T> ObjIntConsumer<T> unchecked(ThrowingObjIntConsumer<T> throwingObjIntConsumer)
	{
		return throwingObjIntConsumer;
	}

	@Override
	default void accept(T t, int value)
	{
		try
		{
			acceptThrows(t, value);
		} catch (Throwable e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	void acceptThrows(T t, int value);
}