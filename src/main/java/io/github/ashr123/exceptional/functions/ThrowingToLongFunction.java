package io.github.ashr123.exceptional.functions;

import java.util.function.ToLongFunction;

@FunctionalInterface
public interface ThrowingToLongFunction<T, X extends Throwable> extends ToLongFunction<T> {
	static <T> ToLongFunction<T> unchecked(ThrowingToLongFunction<T, ?> throwingToLongFunction) {
		return throwingToLongFunction;
	}

	@Override
	default long applyAsLong(T value) {
		try {
			return applyAsLongThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	long applyAsLongThrows(T value) throws X;
}
