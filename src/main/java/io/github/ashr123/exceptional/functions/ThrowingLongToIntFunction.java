package io.github.ashr123.exceptional.functions;

import java.util.function.LongToIntFunction;

@FunctionalInterface
public interface ThrowingLongToIntFunction<X extends Throwable> extends LongToIntFunction {
	static LongToIntFunction unchecked(ThrowingLongToIntFunction<?> longToIntFunction) {
		return longToIntFunction;
	}

	@Override
	default int applyAsInt(long value) {
		try {
			return applyAsIntThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int applyAsIntThrows(long value) throws X;
}
