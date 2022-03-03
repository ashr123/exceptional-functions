package exceptional.functions;

import java.util.function.IntFunction;

@FunctionalInterface
public interface ThrowingIntFunction<R> extends IntFunction<R>
{
	@Override
	default R apply(int value)
	{
		try
		{
			return applyThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	R applyThrows(int value) throws Exception;
}