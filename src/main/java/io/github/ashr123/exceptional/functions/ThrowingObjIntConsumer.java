package io.github.ashr123.exceptional.functions;

import java.util.function.ObjIntConsumer;

@FunctionalInterface
public interface ThrowingObjIntConsumer<T> extends ObjIntConsumer<T>
{
	@Override
	default void accept(T t, int value)
	{
		try
		{
			acceptThrows(t, value);
		} catch (Throwable e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(T t, int value);
}