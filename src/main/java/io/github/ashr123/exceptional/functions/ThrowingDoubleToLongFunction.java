package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleToLongFunction;

@FunctionalInterface
public interface ThrowingDoubleToLongFunction<X extends Throwable> extends DoubleToLongFunction {
	static DoubleToLongFunction unchecked(ThrowingDoubleToLongFunction<?> doubleToLongFunction) {
		return doubleToLongFunction;
	}

	@Override
	default long applyAsLong(double value) {
		try {
			return applyAsLongThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	long applyAsLongThrows(double value) throws X;
}
