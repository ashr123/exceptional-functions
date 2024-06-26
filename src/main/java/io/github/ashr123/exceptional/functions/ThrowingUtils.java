package io.github.ashr123.exceptional.functions;

public class ThrowingUtils {
	private ThrowingUtils() {
	}

	public static <T extends Throwable> RuntimeException sneakyThrow(Throwable t) throws T {
		//noinspection unchecked
		throw (T) t;
	}

	public static RuntimeException getRuntimeException(Throwable t) {
		return t instanceof RuntimeException ?
				(RuntimeException) t :
				new RuntimeException(t);
	}
}
