package exceptional.functions;

import java.util.function.ToLongFunction;

@FunctionalInterface
public interface ThrowingToLongFunction<T> extends ToLongFunction<T>
{
	@Override
	default long applyAsLong(T value)
	{
		try
		{
			return applyAsLongThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	long applyAsLongThrows(T value) throws Exception;
}