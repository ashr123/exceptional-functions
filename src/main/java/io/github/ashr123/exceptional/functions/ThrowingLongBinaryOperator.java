package io.github.ashr123.exceptional.functions;

import java.util.function.LongBinaryOperator;

@FunctionalInterface
public interface ThrowingLongBinaryOperator<X extends Throwable> extends LongBinaryOperator {
	static LongBinaryOperator unchecked(ThrowingLongBinaryOperator<?> longBinaryOperator) {
		return longBinaryOperator;
	}

	@Override
	default long applyAsLong(long left, long right) {
		try {
			return applyAsLongThrows(left, right);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	long applyAsLongThrows(long left, long right) throws X;
}
