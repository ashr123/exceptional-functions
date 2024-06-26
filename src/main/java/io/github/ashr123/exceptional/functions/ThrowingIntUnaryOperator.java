package io.github.ashr123.exceptional.functions;

import java.util.function.IntUnaryOperator;

@FunctionalInterface
public interface ThrowingIntUnaryOperator<X extends Throwable> extends IntUnaryOperator {
	static IntUnaryOperator unchecked(ThrowingIntUnaryOperator<?> intUnaryOperator) {
		return intUnaryOperator;
	}

	@Override
	default int applyAsInt(int operand) {
		try {
			return applyAsIntThrows(operand);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int applyAsIntThrows(int operand) throws X;
}
