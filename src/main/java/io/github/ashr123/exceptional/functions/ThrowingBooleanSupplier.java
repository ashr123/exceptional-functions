package io.github.ashr123.exceptional.functions;

import java.util.function.BooleanSupplier;

@FunctionalInterface
public interface ThrowingBooleanSupplier<X extends Throwable> extends BooleanSupplier {
	static BooleanSupplier unchecked(ThrowingBooleanSupplier<?> booleanSupplier) {
		return booleanSupplier;
	}

	@Override
	default boolean getAsBoolean() {
		try {
			return getAsBooleanThrows();
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	boolean getAsBooleanThrows() throws X;
}
