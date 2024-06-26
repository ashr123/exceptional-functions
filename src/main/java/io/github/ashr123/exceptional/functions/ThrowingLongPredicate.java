package io.github.ashr123.exceptional.functions;

import java.util.function.LongPredicate;

@FunctionalInterface
public interface ThrowingLongPredicate<X extends Throwable> extends LongPredicate {
	static LongPredicate unchecked(ThrowingLongPredicate<?> longPredicate) {
		return longPredicate;
	}

	@Override
	default boolean test(long value) {
		try {
			return testThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	boolean testThrows(long value) throws X;
}
