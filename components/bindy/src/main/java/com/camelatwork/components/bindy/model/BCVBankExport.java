package com.camelatwork.components.bindy.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcomaccio on 11/06/2015.
 */
@CsvRecord(separator =",", skipFirstLine = true)
public class BCVBankExport implements Serializable {

    private static final long serialVersionUID = 1L;

    @DataField(pos = 1, pattern = "dd.MM.yyyy")
    private Date executionDate;

    @DataField(pos = 2)
    private String transactions;

    @DataField(pos = 3)
    private double debit;

    @DataField(pos = 4)
    private double credit;

    @DataField(pos = 5, pattern = "dd.MM.yyyy")
    private Date valueDate;

    @DataField(pos = 6)
    private double balance;

    @DataField(pos = 7)
    private String note;

    /**
     *
     * @return
     */
    public Date getExecutionDate() {
        return executionDate;
    }

    /**
     *
     * @param executionDate
     */
    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    /**
     *
     * @return
     */
    public String getTransactions() {
        return transactions;
    }

    /**
     *
     * @param transactions
     */
    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    /**
     *
     * @return
     */
    public double getDebit() {
        return debit;
    }

    /**
     *
     * @param debit
     */
    public void setDebit(double debit) {
        this.debit = debit;
    }

    /**
     *
     * @return
     */
    public double getCredit() {
        return credit;
    }

    /**
     *
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     *
     * @return
     */
    public Date getValueDate() {
        return valueDate;
    }

    /**
     *
     * @param valueDate
     */
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     */
    public String getNote() {
        return note;
    }

    /**
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

}
