package com.camelatwork.components.bindy.model.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by marcomaccio on 13/05/2016.
 */
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date    executionDate;
    private String  description;
    private double  debit;
    private double  credit;
    private Date    valueDate;
    private double  balance;
    private String  note;

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "executionDate=" + executionDate +
                ", description='" + description + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", valueDate=" + valueDate +
                ", balance=" + balance +
                ", note='" + note + '\'' +
                '}';
    }
}
