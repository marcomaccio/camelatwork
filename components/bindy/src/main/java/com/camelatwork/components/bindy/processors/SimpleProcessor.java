package com.camelatwork.components.bindy.processors;

import com.camelatwork.components.bindy.model.to.BCVAccountStatement;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.HashMap;

/**
 * Created by marcomaccio on 13/05/2016.
 */
public class SimpleProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        HashMap<String, Object> map = (HashMap<String, Object>) exchange.getIn().getBody();

        for (String key : map.keySet()) {

            System.out.println("key : " + key);
            BCVAccountStatement object = (BCVAccountStatement)map.get(key);
            System.out.println("value : " + object.toString());
        }


    }
}
