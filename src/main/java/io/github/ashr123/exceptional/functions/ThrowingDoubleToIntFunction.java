package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleToIntFunction;

@FunctionalInterface
public interface ThrowingDoubleToIntFunction<X extends Throwable> extends DoubleToIntFunction {
	static DoubleToIntFunction unchecked(ThrowingDoubleToIntFunction<?> doubleToIntFunction) {
		return doubleToIntFunction;
	}

	@Override
	default int applyAsInt(double value) {
		try {
			return applyAsIntThrows(value);
		} catch (Throwable x) {
			throw ThrowingUtils.sneakyThrow(x);
		}
	}

	int applyAsIntThrows(double value) throws X;
}
