package exceptional.functions;

import java.util.function.LongConsumer;

@FunctionalInterface
public interface ThrowingLongConsumer extends LongConsumer
{
	@Override
	default void accept(long value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(long value) throws Exception;
}