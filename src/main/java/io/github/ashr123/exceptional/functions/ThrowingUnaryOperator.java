package io.github.ashr123.exceptional.functions;

@FunctionalInterface
public interface ThrowingUnaryOperator<T> extends ThrowingFunction<T, T>
{
	static <T> ThrowingUnaryOperator<T> identity()
	{
		return t -> t;
	} //TODO think if needed
}