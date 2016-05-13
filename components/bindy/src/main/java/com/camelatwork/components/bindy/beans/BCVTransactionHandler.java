package com.camelatwork.components.bindy.beans;

import com.camelatwork.components.bindy.model.bo.Transaction;
import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 13/05/2016.
 */
public class BCVTransactionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(BCVTransactionHandler.class);

    @Handler
    public void handleTransaction(Transaction transaction){
        LOGGER.debug("Now we handle the transaction: \n " +
                    "Exec date:     "   +   transaction.getExecutionDate()    + "\n" +
                    "Value date:    "   +   transaction.getValueDate()        + "\n" +
                    "Description:   "   +   transaction.getDescription()
        );
    }
}
