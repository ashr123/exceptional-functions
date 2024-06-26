package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleFunction;

@FunctionalInterface
public interface ThrowingDoubleFunction<R, X extends Throwable> extends DoubleFunction<R> {
	static <R> DoubleFunction<R> unchecked(ThrowingDoubleFunction<R, ?> throwingDoubleFunction) {
		return throwingDoubleFunction;
	}

	@Override
	default R apply(double value) {
		try {
			return applyThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	R applyThrows(double value) throws X;
}
