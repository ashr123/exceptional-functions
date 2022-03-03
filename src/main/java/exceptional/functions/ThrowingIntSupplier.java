package exceptional.functions;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface ThrowingIntSupplier extends IntSupplier
{
	@Override
	default int getAsInt()
	{
		try
		{
			return getAsIntThrows();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int getAsIntThrows() throws Exception;
}