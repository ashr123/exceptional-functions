package exceptional.functions;

import java.util.function.ObjLongConsumer;

@FunctionalInterface
public interface ThrowingObjLongConsumer<T> extends ObjLongConsumer<T>
{
	@Override
	default void accept(T t, long value)
	{
		try
		{
			acceptThrows(t, value);
		} catch (Throwable e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(T t, long value) throws Throwable;
}