package com.fsu.edp;

import com.fsu.edp.engine.Engine;
import com.fsu.edp.model.Index;
import com.fsu.edp.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws InterruptedException {
        logger.info("Starting EDP");

        String fileName = args[0];
        long numOfLabels = Long.parseLong(args[1]);
        long numOfVertices = Long.parseLong(args[2]);
        long numOfQueries = Long.parseLong(args[3]);
        long finalSrc = 1L;
        long finalDst = 9L;
        logger.info("Received args FileName ==> {}", fileName);
        logger.info("Number of Labels/Partitions ==> {}", numOfLabels);

        if(args.length > 4){
            finalSrc = Long.parseLong(args[4]);
            finalDst = Long.parseLong(args[5]);
        }
        long numOfLabelsToCreate = numOfLabels / 2;
        if(args.length > 5){
            numOfLabelsToCreate = Long.parseLong(args[6]);
        }
        logger.info("Max number of Partitions to be used ==> {}", numOfLabelsToCreate);
        logger.info("To find distance between src ==> {} and target ==> {}", finalSrc, finalDst);
        logger.info("Starting program in 5 seconds");
        Thread.sleep(5000);
        Random rand = new Random();

        logger.info("Running AlgorithmOne from paper");
        Index index = Engine.runAlgorithmOne(fileName, numOfLabels);

        Set<Long> labels = new HashSet<>();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<numOfQueries;i++){
            if(labels.size() < numOfLabelsToCreate ){
                int randomLabelNum = rand.nextInt(Math.toIntExact(numOfLabels));
                labels.add((long) randomLabelNum);
            }
            logger.info("Loaded partition ==> {}", labels);
            // Select a random Source and Target to simulate user Query
            Long src = (long) rand.nextInt(Math.toIntExact(numOfVertices));
            Long dst = (long) rand.nextInt(Math.toIntExact(numOfVertices));
            logger.info("Finding route between src ==> {} target ==> {} Executing Query no ==> {}", src, dst, i);
            Long cost = Engine.runAlgorithmTwo(index, src, dst, labels);
            Utils.checkCostAndPrint(cost, src, dst);
            long totalEntries = 0L;
            for(long j=0; j< numOfLabels;j++){
                totalEntries += index.getPartition(j).getCostSize();
            }
            logger.info("Total number of entries in Index ==> {}", totalEntries);

        }
        long endTime = System.currentTimeMillis();
        logger.info("Total execution time for {} queries ==> {} seconds", numOfQueries, (endTime-startTime) / 1000 );

        Utils.checkCostAndPrint(Engine.runAlgorithmTwo(index, finalSrc, finalDst, labels), finalSrc, finalDst);


    }
}