package io.github.ashr123.exceptional.functions;

public class ThrowingUtils {
	private ThrowingUtils() {
	}

	public static RuntimeException getRuntimeException(Exception e) {
		return e instanceof RuntimeException ? (RuntimeException) e : new RuntimeException(e);
	}
}
