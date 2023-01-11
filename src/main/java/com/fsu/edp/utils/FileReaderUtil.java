package com.fsu.edp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileReaderUtil {

    private static final Logger logger = LoggerFactory.getLogger(FileReaderUtil.class);

    /**
     *
     * @param fileName - Path of file
     * @param src - List to store source node
     * @param dst - List to store destination node
     * @param weight - List to store weight
     * @param label - List to hold partition
     */
    public static void readFile(String fileName, List<Long> src, List<Long> dst, List<Long> weight, List<Long> label){
        logger.info("Reading from file ==> {}", fileName);
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(e -> {
                String[] data = e.split(" ");
                src.add(Long.valueOf(data[0]));
                dst.add(Long.valueOf(data[1]));
                weight.add(Long.valueOf(data[2]));
                label.add(Long.valueOf(data[3]));
            });
        } catch (Exception e) {
            logger.error("Failed to read file", e);

        }
        logger.info("Read from file found count ==> {}", src.size());
        logger.info("Unique Source Vertex ==> {}", src.stream().distinct().count());
        logger.info("Unique Destination Vertex ==> {}", dst.stream().distinct().count());
        logger.info("Total number of partitions found ==> {}", label.stream().distinct().count());
    }
}
