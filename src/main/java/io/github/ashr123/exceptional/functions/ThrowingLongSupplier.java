package io.github.ashr123.exceptional.functions;

import java.util.function.LongSupplier;

@FunctionalInterface
public interface ThrowingLongSupplier<X extends Throwable> extends LongSupplier {
	static LongSupplier unchecked(ThrowingLongSupplier<?> longSupplier) {
		return longSupplier;
	}

	@Override
	default long getAsLong() {
		try {
			return getAsLongThrows();
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	long getAsLongThrows() throws X;
}
