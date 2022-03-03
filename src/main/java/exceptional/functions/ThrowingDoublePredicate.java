package exceptional.functions;

import java.util.function.DoublePredicate;

@FunctionalInterface
public interface ThrowingDoublePredicate extends DoublePredicate
{
	@Override
	default boolean test(double value)
	{
		try
		{
			return testThrows(value);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	boolean testThrows(double value) throws Exception;
}