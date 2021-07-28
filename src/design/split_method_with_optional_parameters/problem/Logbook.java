/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package design.split_method_with_optional_parameters.problem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

class Logbook {

    static final Path CREW_LOG = Paths.get("/var/log/crew.log");

    List<String> readEntries(LocalDate date) throws IOException {
        final List<String> entries = Files.readAllLines(CREW_LOG,
                StandardCharsets.UTF_8);

        // date == null 일수 있다는 말은, 해당 매개변수가 선택사항이라는 뜻.
        // 이러한 옵션 매개변수가 있으면, 해당 메서드는 2가지 일을 한다 ( null을 판단하고, 그리도 다른일..)
        //
        if (date == null) {
            return entries;
        }

        List<String> result = new LinkedList<>();
        for (String entry : entries) {
            if (entry.startsWith(date.toString())) {
                result.add(entry);
            }
        }
        return result;
    }
}

class Main {
    static void usage() throws IOException {
        Logbook logbook = new Logbook();
        List<String> completeLog = logbook.readEntries(null);

        final LocalDate moonLanding = LocalDate.of(1969, Month.JULY, 20);
        List<String> moonLandingLog = logbook.readEntries(moonLanding);
    }
}