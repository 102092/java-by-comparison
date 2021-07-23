/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
***/
package testing.let_junit_handle_exceptions.problem;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testing.let_junit_handle_exceptions.Logbook;

class LogbookTest {

    @Test
    void readLogbook() {
        Logbook logbook = new Logbook();

        try {
            List<String> entries = logbook.readAllEntries();
            Assertions.assertEquals(13, entries.size());
        } catch (IOException e) {
            // 전체 예외에 대한 스택 추적이 어려운 상태
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void readLogbookFail() {
        Logbook logbook = new Logbook();

        try {
            logbook.readAllEntries();
            Assertions.fail("read should fail");
            // 예외가 일어나기를 기대했지만, 실제로 일어나지 않는다.
        } catch (IOException ignored) {}
    }
}

