package exceptional.functions;

import java.util.function.ToDoubleBiFunction;

@FunctionalInterface
public interface ThrowingToDoubleBiFunction<T, U> extends ToDoubleBiFunction<T, U>
{
	@Override
	default double applyAsDouble(T t, U u)
	{
		try
		{
			return applyAsDoubleThrows(t, u);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	double applyAsDoubleThrows(T t, U u) throws Exception;
}