package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleBinaryOperator;

@FunctionalInterface
public interface ThrowingDoubleBinaryOperator<X extends Throwable> extends DoubleBinaryOperator {
	static DoubleBinaryOperator unchecked(ThrowingDoubleBinaryOperator<?> doubleBinaryOperator) {
		return doubleBinaryOperator;
	}

	@Override
	default double applyAsDouble(double left, double right) {
		try {
			return applyAsDoubleThrows(left, right);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	double applyAsDoubleThrows(double left, double right) throws X;
}
