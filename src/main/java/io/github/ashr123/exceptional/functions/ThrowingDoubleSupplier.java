package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleSupplier;

@FunctionalInterface
public interface ThrowingDoubleSupplier<X extends Throwable> extends DoubleSupplier {
	static DoubleSupplier unchecked(ThrowingDoubleSupplier<?> doubleSupplier) {
		return doubleSupplier;
	}

	@Override
	default double getAsDouble() {
		try {
			return getAsDoubleThrows();
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	double getAsDoubleThrows() throws X;
}
