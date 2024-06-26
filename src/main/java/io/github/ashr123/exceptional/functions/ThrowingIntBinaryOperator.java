package io.github.ashr123.exceptional.functions;

import java.util.function.IntBinaryOperator;

@FunctionalInterface
public interface ThrowingIntBinaryOperator<X extends Throwable> extends IntBinaryOperator {
	static IntBinaryOperator unchecked(ThrowingIntBinaryOperator<?> intBinaryOperator) {
		return intBinaryOperator;
	}

	@Override
	default int applyAsInt(int left, int right) {
		try {
			return applyAsIntThrows(left, right);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int applyAsIntThrows(int left, int right) throws X;
}
