package io.github.ashr123.exceptional.functions;

import java.util.function.ToDoubleFunction;

@FunctionalInterface
public interface ThrowingToDoubleFunction<T, X extends Throwable> extends ToDoubleFunction<T> {
	static <T> ToDoubleFunction<T> unchecked(ThrowingToDoubleFunction<T, ?> throwingToDoubleFunction) {
		return throwingToDoubleFunction;
	}

	@Override
	default double applyAsDouble(T value) {
		try {
			return applyAsDoubleThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	double applyAsDoubleThrows(T value) throws X;
}
