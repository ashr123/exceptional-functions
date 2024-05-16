package io.github.ashr123.exceptional.functions;

import java.util.function.LongSupplier;

@FunctionalInterface
public interface ThrowingLongSupplier extends LongSupplier {
	@Override
	default long getAsLong() {
		try {
			return getAsLongThrows();
		} catch (Exception e) {
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	long getAsLongThrows() throws Exception;
}
