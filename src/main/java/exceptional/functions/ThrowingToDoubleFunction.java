package exceptional.functions;

import java.util.function.ToDoubleFunction;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T> extends ToDoubleFunction<T>
{
	@Override
	default double applyAsDouble(T value)
	{
		try
		{
			return applyAsDoubleThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	double applyAsDoubleThrows(T value) throws Exception;
}