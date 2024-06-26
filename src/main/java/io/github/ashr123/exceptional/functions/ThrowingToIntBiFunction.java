package io.github.ashr123.exceptional.functions;

import java.util.function.ToIntBiFunction;

@FunctionalInterface
public interface ThrowingToIntBiFunction<T, U, X extends Throwable> extends ToIntBiFunction<T, U> {
	static <T, U> ToIntBiFunction<T, U> unchecked(ThrowingToIntBiFunction<T, U, ?> throwingToIntBiFunction) {
		return throwingToIntBiFunction;
	}

	@Override
	default int applyAsInt(T t, U u) {
		try {
			return applyAsIntThrows(t, u);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int applyAsIntThrows(T t, U u) throws X;
}
