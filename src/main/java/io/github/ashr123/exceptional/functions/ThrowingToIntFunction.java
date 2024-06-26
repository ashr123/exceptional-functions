package io.github.ashr123.exceptional.functions;

import java.util.function.ToIntFunction;

@FunctionalInterface
public interface ThrowingToIntFunction<T, X extends Throwable> extends ToIntFunction<T> {
	static <T> ToIntFunction<T> unchecked(ThrowingToIntFunction<T, ?> throwingToIntFunction) {
		return throwingToIntFunction;
	}

	@Override
	default int applyAsInt(T value) {
		try {
			return applyAsIntThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int applyAsIntThrows(T value) throws X;
}
