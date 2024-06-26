package io.github.ashr123.exceptional.functions;

import java.util.function.IntConsumer;

@FunctionalInterface
public interface ThrowingIntConsumer<X extends Throwable> extends IntConsumer {
	static IntConsumer unchecked(ThrowingIntConsumer<?> intConsumer) {
		return intConsumer;
	}

	@Override
	default void accept(int value) {
		try {
			acceptThrows(value);
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void acceptThrows(int value) throws X;
}
