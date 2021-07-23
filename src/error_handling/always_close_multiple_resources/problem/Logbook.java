/***
 * Excerpted from "Java By Comparison",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/javacomp for more book information.
 ***/
package error_handling.always_close_multiple_resources.problem;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Logbook {

    static final Path LOG_FOLDER = Paths.get("/var/log");
    static final Path STATISTICS_CSV = LOG_FOLDER.resolve("stats.csv");
    static final String FILE_FILTER = "*.log";

    void createStatistics() throws IOException {
//        DirectoryStream<Path> directoryStream =
//                Files.newDirectoryStream(LOG_FOLDER, FILE_FILTER);
//        BufferedWriter writer =
//                Files.newBufferedWriter(STATISTICS_CSV);
        // 문제점은 write 생성에 문제가 있어 예외가 던져지면, directoryStream은 제대로 닫히지 않음.

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(LOG_FOLDER, FILE_FILTER);
             BufferedWriter writer = Files.newBufferedWriter(STATISTICS_CSV)) {
            for (Path logFile : directoryStream) {
                final String csvLine = String.format("%s,%d,%s",
                    logFile,
                    Files.size(logFile),
                    Files.getLastModifiedTime(logFile));
                writer.write(csvLine);
                writer.newLine();
            }
        }
//        } finally {
//            // directorStream.close()에서 예외가 발생하면, writer.close() 가 제대로 닫히지 않음.
//            directoryStream.close();
//            writer.close();
//        }
    }
}
