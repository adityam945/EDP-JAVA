package com.fsu.edp.utils;

import com.fsu.edp.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void checkCostAndPrint(long cost, long src, long dst){
        if(cost == Long.MAX_VALUE){
            logger.info("Could not find route between src ==> {} target ==> {}", src, dst);
        }else{
            logger.info("Found route between src ==> {} target ==> {} with cost ==> {}", src, dst, cost);
        }
    }
}
