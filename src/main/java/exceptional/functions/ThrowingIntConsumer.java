package exceptional.functions;

import java.util.function.IntConsumer;

@FunctionalInterface
public interface ThrowingIntConsumer extends IntConsumer
{
	@Override
	default void accept(int value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(int value) throws Exception;
}