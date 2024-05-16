package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleConsumer;

@FunctionalInterface
public interface ThrowingDoubleConsumer extends DoubleConsumer {
	@Override
	default void accept(double value) {
		try {
			acceptThrows(value);
		} catch (Exception e) {
			throw ThrowingUtils.getRuntimeException(e);
		}
	}

	void acceptThrows(double value) throws Exception;
}
