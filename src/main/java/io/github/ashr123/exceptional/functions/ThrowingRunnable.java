package io.github.ashr123.exceptional.functions;

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
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	void runThrows() throws Exception;
}