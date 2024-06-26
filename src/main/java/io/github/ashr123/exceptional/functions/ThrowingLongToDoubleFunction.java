package io.github.ashr123.exceptional.functions;

import java.util.function.LongToDoubleFunction;

@FunctionalInterface
public interface ThrowingLongToDoubleFunction<X extends Throwable> extends LongToDoubleFunction {
	static LongToDoubleFunction unchecked(ThrowingLongToDoubleFunction<?> longToDoubleFunction) {
		return longToDoubleFunction;
	}

	@Override
	default double applyAsDouble(long value) {
		try {
			return applyAsDoubleThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	double applyAsDoubleThrows(long value) throws X;
}
