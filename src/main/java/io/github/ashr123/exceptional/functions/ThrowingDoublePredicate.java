package io.github.ashr123.exceptional.functions;

import java.util.function.DoublePredicate;

@FunctionalInterface
public interface ThrowingDoublePredicate<X extends Throwable> extends DoublePredicate {
	static DoublePredicate unchecked(ThrowingDoublePredicate<?> doublePredicate) {
		return doublePredicate;
	}

	@Override
	default boolean test(double value) {
		try {
			return testThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	boolean testThrows(double value) throws X;
}
