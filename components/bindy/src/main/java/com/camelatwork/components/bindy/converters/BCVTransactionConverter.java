package com.camelatwork.components.bindy.converters;

import com.camelatwork.components.bindy.model.bo.Transaction;
import com.camelatwork.components.bindy.model.to.BCVAccountStatement;
import org.apache.camel.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 12/06/2015.
 */
@Converter
public class BCVTransactionConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BCVTransactionConverter.class);

    /**
     *
     * @param bcvAccountStatement
     */
    @Converter
    public static Transaction toTransaction(BCVAccountStatement bcvAccountStatement) throws Exception {

        LOGGER.debug("Single Movement: \n " +
                "Exec date: "   +   bcvAccountStatement.getExecutionDate()     + "\n " +
                "Description: " +   bcvAccountStatement.getTransaction()       + "\n " +
                "Credit:  "     +   bcvAccountStatement.getCredit()            + "\n " +
                "Debit :  "     +   bcvAccountStatement.getDebit()             + "\n " +
                "Balance: "     +   bcvAccountStatement.getBalance()           + "\n " +
                "Value date: "  +   bcvAccountStatement.getValueDate()
                );

        Transaction transaction = new Transaction();

        transaction.setExecutionDate(bcvAccountStatement.getExecutionDate());
        transaction.setDescription(bcvAccountStatement.getTransaction());
        transaction.setValueDate(bcvAccountStatement.getValueDate());
        transaction.setDebit(bcvAccountStatement.getDebit());
        transaction.setCredit(bcvAccountStatement.getCredit());
        transaction.setBalance(bcvAccountStatement.getBalance());
        transaction.setNote(bcvAccountStatement.getNote());

        return transaction;
    }
}
