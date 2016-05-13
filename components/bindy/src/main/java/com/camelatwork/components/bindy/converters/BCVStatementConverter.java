package com.camelatwork.components.bindy.converters;

import com.camelatwork.components.bindy.model.to.BCVAccountStatement;
import org.apache.camel.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Created by marcomaccio on 13/05/2016.
 */
@Converter
public class BCVStatementConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BCVStatementConverter.class);

    @Converter
    public BCVAccountStatement toBCVAccountStatement(HashMap<String, BCVAccountStatement> map) {
        BCVAccountStatement accountStatement = null;
        for (String key : map.keySet()) {
            accountStatement = (BCVAccountStatement) map.get(key);
        }
        return accountStatement;
    }
}
