package io.github.ashr123.exceptional.functions;

import java.util.function.IntSupplier;

@FunctionalInterface
public interface ThrowingIntSupplier<X extends Throwable> extends IntSupplier {
	static IntSupplier unchecked(ThrowingIntSupplier<?> intSupplier) {
		return intSupplier;
	}

	@Override
	default int getAsInt() {
		try {
			return getAsIntThrows();
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int getAsIntThrows() throws X;
}
