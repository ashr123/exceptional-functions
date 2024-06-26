package io.github.ashr123.exceptional.functions;

import java.util.function.LongConsumer;

@FunctionalInterface
public interface ThrowingLongConsumer<X extends Throwable> extends LongConsumer {
	static LongConsumer unchecked(ThrowingLongConsumer<?> longConsumer) {
		return longConsumer;
	}

	@Override
	default void accept(long value) {
		try {
			acceptThrows(value);
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void acceptThrows(long value) throws X;
}
