package io.github.ashr123.exceptional.functions;

import java.util.function.ObjLongConsumer;

@FunctionalInterface
public interface ThrowingObjLongConsumer<T> extends ObjLongConsumer<T>
{
	static <T> ObjLongConsumer<T> unchecked(ThrowingObjLongConsumer<T> throwingObjLongConsumer)
	{
		return throwingObjLongConsumer;
	}

	@Override
	default void accept(T t, long value)
	{
		try
		{
			acceptThrows(t, value);
		} catch (Exception e)
		{
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	void acceptThrows(T t, long value) throws Exception;
}