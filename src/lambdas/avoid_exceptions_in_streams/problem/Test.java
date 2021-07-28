/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
 ***/
package lambdas.avoid_exceptions_in_streams.problem;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Test {

}

class LogBook {

    LogBook(Path path) throws IOException {
        Files.readAllLines(path);
    }

    static boolean isLogbook(Path path) {
        return false;
    }
}

class LogBooks {

    // IO 에서 생성될 수 있는 자원을 닫아야하고, try-with resource 를 사용해서
    //
    static List<LogBook> getAll() throws IOException {
        try (Stream<Path> stream = Files.walk(Paths.get("/var/log"))) {
            return stream.filter(Files::isRegularFile)
                .filter(LogBook::isLogbook)
                .flatMap(path -> {
                    try {
                        return Stream.of(new LogBook(path));
                    } catch (IOException e) {
                        return Stream.empty();
                    }
                })
                .collect(Collectors.toList());
        }
    }
}
