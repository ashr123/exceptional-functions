package exceptional.functions;

import java.util.function.DoubleConsumer;

@FunctionalInterface
public interface ThrowingDoubleConsumer extends DoubleConsumer
{
	@Override
	default void accept(double value)
	{
		try
		{
			acceptThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	void acceptThrows(double value) throws Exception;
}