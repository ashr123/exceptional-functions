package io.github.ashr123.exceptional.functions;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T, X extends Throwable> extends Consumer<T> {
	static <T> Consumer<T> unchecked(ThrowingConsumer<T, ?> throwingConsumer) {
		return throwingConsumer;
	}

	@Override
	default void accept(final T t) {
		try {
			acceptThrows(t);
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void acceptThrows(T t) throws X;
}
