package io.github.ashr123.exceptional.functions;

@FunctionalInterface
public interface ThrowingRunnable<X extends Throwable> extends Runnable {
	static Runnable unchecked(ThrowingRunnable<?> runnable) {
		return runnable;
	}

	@Override
	default void run() {
		try {
			runThrows();
		} catch (Throwable x) {
			ThrowingUtils.sneakyThrow(x);
		}
	}

	void runThrows() throws X;
}
