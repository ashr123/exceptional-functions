package exceptional.functions;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface ThrowingIntPredicate extends IntPredicate
{
	@Override
	default boolean test(int value)
	{
		try
		{
			return testThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	boolean testThrows(int value) throws Exception;
}