package io.github.ashr123.exceptional.functions;

import java.util.function.IntToLongFunction;

@FunctionalInterface
public interface ThrowingIntToLongFunction<X extends Throwable> extends IntToLongFunction {
	static IntToLongFunction unchecked(ThrowingIntToLongFunction<?> intToLongFunction) {
		return intToLongFunction;
	}

	@Override
	default long applyAsLong(int value) {
		try {
			return applyAsLongThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	long applyAsLongThrows(int value) throws X;
}
