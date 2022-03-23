package io.github.ashr123.exceptional.functions;

@FunctionalInterface
public interface ThrowingRunnable extends Runnable
{
	static Runnable unchecked(ThrowingRunnable throwingRunnable)
	{
		return throwingRunnable;
	}

	@Override
	default void run()
	{
		try
		{
			runThrows();
		} catch (Exception e)
		{
			throw e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
		}
	}

	void runThrows() throws Exception;
}