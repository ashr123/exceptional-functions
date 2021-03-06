package io.github.ashr123.exceptional.functions;

import java.util.function.ObjDoubleConsumer;

@FunctionalInterface
public interface ThrowingObjDoubleConsumer<T> extends ObjDoubleConsumer<T>
{
	static <T> ObjDoubleConsumer<T> unchecked(ThrowingObjDoubleConsumer<T> throwingObjDoubleConsumer)
	{
		return throwingObjDoubleConsumer;
	}

	@Override
	default void accept(T t, double value)
	{
		try
		{
			acceptThrows(t, value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	void acceptThrows(T t, double value) throws Exception;
}