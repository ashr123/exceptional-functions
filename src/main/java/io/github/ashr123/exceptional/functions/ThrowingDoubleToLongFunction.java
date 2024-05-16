package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleToLongFunction;

@FunctionalInterface
public interface ThrowingDoubleToLongFunction extends DoubleToLongFunction {
	@Override
	default long applyAsLong(double value) {
		try {
			return applyAsLongThrows(value);
		} catch (Exception e) {
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	long applyAsLongThrows(double value) throws Exception;
}
