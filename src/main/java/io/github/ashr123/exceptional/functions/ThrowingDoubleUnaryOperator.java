package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleUnaryOperator;

@FunctionalInterface
public interface ThrowingDoubleUnaryOperator<X extends Throwable> extends DoubleUnaryOperator {
	static DoubleUnaryOperator unchecked(ThrowingDoubleUnaryOperator<?> doubleUnaryOperator) {
		return doubleUnaryOperator;
	}

	@Override
	default double applyAsDouble(double operand) {
		try {
			return applyAsDoubleThrows(operand);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	double applyAsDoubleThrows(double operand) throws X;
}
