package ru.parfenov.leetcode.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadAndWriteInFile {
    private static final String PATH_READ = "src/main/resources/text.txt";
    private static final String PATH_WRITE = "src/main/resources/textResult.txt";
    private static final int limitLines = 2000;
    private static final int startNumberUUID = 8100;

    /**
     * result line:
     * ('22f8b58e-116e-4790-bdb3-d3202cef8101', '2023-08-02T17:36:41.659+03:00', '2023-08-02T17:36:41.659+03:00', 0, '2', 'учебная литература'),
     */

    public static void main(String[] args) {

        AtomicInteger UUID = new AtomicInteger(startNumberUUID);
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_READ));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(PATH_WRITE))) {

            reader.lines()
                    .limit(limitLines)
                    .map(line -> line.split("\t"))
                    .map(arraySubString -> getResultLine(arraySubString, UUID.getAndIncrement()))
                    .forEach(resultLine -> {
                        System.out.print(resultLine);

                        try {
                            writer.write(resultLine);
                        } catch (IOException e) {
                            System.err.println(e.getMessage());
                        }
                    });

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String getResultLine(String[] arr, int UUID) {
        return String.format("('22f8b58e-116e-4790-bdb3-d3202cef%d', '2023-08-02T17:36:41.659+03:00', '2023-08-02T17:36:41.659+03:00', 0, '%s', '%s'),%n",
                UUID, arr[0], arr[1].trim());
    }
}


