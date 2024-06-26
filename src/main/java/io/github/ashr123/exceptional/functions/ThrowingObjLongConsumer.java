package io.github.ashr123.exceptional.functions;

import java.util.function.ObjLongConsumer;

@FunctionalInterface
public interface ThrowingObjLongConsumer<T, X extends Throwable> extends ObjLongConsumer<T> {
	static <T> ObjLongConsumer<T> unchecked(ThrowingObjLongConsumer<T, ?> throwingObjLongConsumer) {
		return throwingObjLongConsumer;
	}

	@Override
	default void accept(T t, long value) {
		try {
			acceptThrows(t, value);
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void acceptThrows(T t, long value) throws X;
}
