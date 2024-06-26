package io.github.ashr123.exceptional.functions;

import java.util.function.ObjDoubleConsumer;

@FunctionalInterface
public interface ThrowingObjDoubleConsumer<T, X extends Throwable> extends ObjDoubleConsumer<T> {
	static <T> ObjDoubleConsumer<T> unchecked(ThrowingObjDoubleConsumer<T, ?> throwingObjDoubleConsumer) {
		return throwingObjDoubleConsumer;
	}

	@Override
	default void accept(T t, double value) {
		try {
			acceptThrows(t, value);
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void acceptThrows(T t, double value) throws X;
}
