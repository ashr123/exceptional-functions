package exceptional.functions;

import java.util.function.LongBinaryOperator;

@FunctionalInterface
public interface ThrowingLongBinaryOperator extends LongBinaryOperator
{
	@Override
	default long applyAsLong(long left, long right)
	{
		try
		{
			return applyAsLongThrows(left, right);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	long applyAsLongThrows(long left, long right) throws Exception;
}