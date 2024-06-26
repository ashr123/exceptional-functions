package io.github.ashr123.exceptional.functions;

import java.util.function.Predicate;

@FunctionalInterface
public interface ThrowingPredicate<T, X extends Throwable> extends Predicate<T> {
	static <T> Predicate<T> unchecked(ThrowingPredicate<T, ?> throwingPredicate) {
		return throwingPredicate;
	}

	@Override
	default boolean test(T t) {
		try {
			return testThrows(t);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	boolean testThrows(T t) throws X;
}
