package exceptional.functions;

@FunctionalInterface
public interface ThrowingRunnable extends Runnable
{
	@Override
	default void run()
	{
		try
		{
			runThrows();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	void runThrows() throws Exception;
}