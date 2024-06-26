package io.github.ashr123.exceptional.functions;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ThrowingUnaryOperator<T, X extends Throwable> extends UnaryOperator<T>, ThrowingFunction<T, T, X> {
	static <T> UnaryOperator<T> unchecked(ThrowingUnaryOperator<T, ?> throwingUnaryOperator) {
		return throwingUnaryOperator;
	}
}
