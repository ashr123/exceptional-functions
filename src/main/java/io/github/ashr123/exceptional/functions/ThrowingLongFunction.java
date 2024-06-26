package io.github.ashr123.exceptional.functions;

import java.util.function.LongFunction;

@FunctionalInterface
public interface ThrowingLongFunction<R, X extends Throwable> extends LongFunction<R> {
	static <R> LongFunction<R> unchecked(ThrowingLongFunction<R, ?> throwingLongFunction) {
		return throwingLongFunction;
	}

	@Override
	default R apply(long value) {
		try {
			return applyThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	R applyThrows(long value) throws X;
}
