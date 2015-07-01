package com.camelatwork.components.bindy.beans;

import com.camelatwork.components.bindy.model.BCVBankExport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by marcomaccio on 12/06/2015.
 */
public class BCVImportService {

    private static final transient Logger LOGGER = LoggerFactory.getLogger(BCVImportService.class);

    /**
     *
     * @param accountStatement
     */
    public void handleAccountStatement(BCVBankExport accountStatement) {
        LOGGER.debug("Single Movement: " + accountStatement.getExecutionDate() +
                accountStatement.getTransactions() +
                accountStatement.getCredit() +
                accountStatement.getDebit() +
                accountStatement.getBalance());
    }
}
