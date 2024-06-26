package io.github.ashr123.exceptional.functions;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface ThrowingIntPredicate<X extends Throwable> extends IntPredicate {
	static IntPredicate unchecked(ThrowingIntPredicate<?> intPredicate) {
		return intPredicate;
	}

	@Override
	default boolean test(int value) {
		try {
			return testThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	boolean testThrows(int value) throws X;
}
