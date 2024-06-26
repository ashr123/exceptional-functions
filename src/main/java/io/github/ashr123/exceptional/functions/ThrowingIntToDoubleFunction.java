package io.github.ashr123.exceptional.functions;

import java.util.function.IntToDoubleFunction;

@FunctionalInterface
public interface ThrowingIntToDoubleFunction<X extends Throwable> extends IntToDoubleFunction {
	static IntToDoubleFunction unchecked(ThrowingIntToDoubleFunction<?> intToDoubleFunction) {
		return intToDoubleFunction;
	}

	@Override
	default double applyAsDouble(int value) {
		try {
			return applyAsDoubleThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	double applyAsDoubleThrows(int value) throws X;
}
