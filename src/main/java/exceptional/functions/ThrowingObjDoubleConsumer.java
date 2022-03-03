package exceptional.functions;

import java.util.function.ObjDoubleConsumer;

@FunctionalInterface
public interface ThrowingObjDoubleConsumer<T> extends ObjDoubleConsumer<T>
{
	@Override
	default void accept(T t, double value)
	{
		try
		{
			acceptThrows(t, value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(T t, double value) throws Exception;
}