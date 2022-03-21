# exceptional-functions

[![Maven Central](https://img.shields.io/maven-central/v/io.github.ashr123/exceptional-functions.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.ashr123%22%20AND%20a:%22exceptional-functions%22)

A collection of functions that protect against unchecked Exceptions.

Code example:

```java
import io.github.ashr123.exceptional.functions.ThrowingFunction;

import java.io.InputStream;
import java.net.URL;

public class Example
{
	public static Stream<InputStream> exampleWithCasting()
	{
		return Stream.of("https://www.google.com",
						"https://www.ynet.com/",
						"https://www,stackoverflow.com")
				.map((ThrowingFunction<String, URL>) URL::new)
				.map(URL::openStream);
	}

	public static Stream<InputStream> exampleWithCallingUnchecked()
	{
		return Stream.of("https://www.google.com",
						"https://www.ynet.com/",
						"https://www,stackoverflow.com")
				.map(ThrowingFunction.unchecked(URL::new))
				.map(URL::openStream);
	}
}
```