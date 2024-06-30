# exceptional-functions

[![Maven Central](https://img.shields.io/maven-central/v/io.github.ashr123/exceptional-functions.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.ashr123%22%20AND%20a:%22exceptional-functions%22)

A collection of functions that protect against unchecked Exceptions.

Code example:

```java
import io.github.ashr123.exceptional.functions.ThrowingFunction;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Example {
    public static Stream<InputStream> exampleWithCasting() {
        return Stream.of(
                        "https://www.google.com",
                        "https://www.ynet.co.il",
                        "https://www.stackoverflow.com"
                )
                .map(URI::create)
                .map((ThrowingFunction<URI, URL, MalformedURLException>) URI::toURL)
                .map((ThrowingFunction<URL, InputStream, IOException>) URL::openStream);
    }

    public static Stream<InputStream> exampleWithCastingAndWildcards() {
        return Stream.of(
                        "https://www.google.com",
                        "https://www.ynet.co.il",
                        "https://www.stackoverflow.com"
                )
                .map(URI::create)
                .map((ThrowingFunction<URI, URL, ?>) URI::toURL)
                .map((ThrowingFunction<URL, InputStream, ?>) URL::openStream);
    }

    public static Stream<InputStream> exampleWithCallingUnchecked() {
        return Stream.of(
                        "https://www.google.com",
                        "https://www.ynet.co.il",
                        "https://www.stackoverflow.com"
                )
                .map(URI::create)
                .map(ThrowingFunction.unchecked(URI::toURL))
                .map(ThrowingFunction.unchecked(URL::openStream));
    }

    public static <R, T extends Throwable> R doSomeAction(URL url, ThrowingFunction<URL, R, T> action) throws T {
        return action.applyThrows(url);
    }
}
```
