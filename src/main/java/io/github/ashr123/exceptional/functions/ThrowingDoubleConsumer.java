package io.github.ashr123.exceptional.functions;

import java.util.function.DoubleConsumer;

@FunctionalInterface
public interface ThrowingDoubleConsumer<X extends Throwable> extends DoubleConsumer {
	static DoubleConsumer unchecked(ThrowingDoubleConsumer<?> doubleConsumer) {
		return doubleConsumer;
	}

	@Override
	default void accept(double value) {
		try {
			acceptThrows(value);
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void acceptThrows(double value) throws X;
}
