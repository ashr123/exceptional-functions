package exceptional.functions;

import java.util.function.IntUnaryOperator;

@FunctionalInterface
public interface ThrowingIntUnaryOperator extends IntUnaryOperator
{
	@Override
	default int applyAsInt(int operand)
	{
		try
		{
			return applyAsIntThrows(operand);
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	int applyAsIntThrows(int operand) throws Exception;
}