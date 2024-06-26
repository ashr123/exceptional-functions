package io.github.ashr123.exceptional.functions;

import java.util.function.IntFunction;

@FunctionalInterface
public interface ThrowingIntFunction<R, X extends Throwable> extends IntFunction<R> {
	static <R> IntFunction<R> unchecked(ThrowingIntFunction<R, ?> throwingIntFunction) {
		return throwingIntFunction;
	}

	@Override
	default R apply(int value) {
		try {
			return applyThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	R applyThrows(int value) throws X;
}
