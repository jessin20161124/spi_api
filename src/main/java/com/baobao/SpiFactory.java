package com.baobao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author zexin.guo
 * @create 2018-03-29 下午5:18
 **/
public class SpiFactory {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static ISpi getSpi() {
        ServiceLoader<ISpi> loader = ServiceLoader.load(ISpi.class);
        List<ISpi> ispiList = new ArrayList<>();
        for (ISpi ispi : loader) {
            ispiList.add(ispi);
        }
        if (ispiList.size() > 2) {
            System.err.println("Mutiple implements found.");
            return null;
        } else if (ispiList.size() < 1) {
            System.err.println("No implements found.");
            return null;
        } else {
            return ispiList.get(0);
        }
    }
}
