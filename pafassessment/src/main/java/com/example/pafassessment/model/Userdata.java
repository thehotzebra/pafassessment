package com.example.pafassessment.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.annotation.PostConstruct;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class Userdata {
    
    private Integer id;

    private String accountId;
    private String firstName;
    private BigDecimal balance;

    @NotNull(message = "Please select a user.")
    private String fromAcc;
    @NotNull(message = "Please select a user.")
    private String toAcc;
    @NotNull(message = "Please enter an amount.")
    @Positive(message = "Transaction amount should be positive with a minimum amount of $10.")
    @Min(value = 10, message = "Minimum transaction amount is $10.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal amount;
    private String comments;
    
    private String transactionId;
    private LocalDate date;
    

    public static Userdata fromSQL(SqlRowSet rs) {
        Userdata userdata = new Userdata();
        userdata.setId(rs.getInt("id"));
        userdata.setAccountId(rs.getString("account_id"));
        userdata.setFirstName(rs.getString("first_name"));
        userdata.setBalance(rs.getBigDecimal("balance"));
        return userdata;

    }

    public static Userdata fromSQLConcat(SqlRowSet rs) {
        Userdata userdata = new Userdata();
        userdata.setAccountId(rs.getString("account_id"));
        userdata.setFirstName(rs.getString("first_name"));
        return userdata;

    }
    
    //for Redis
    public JsonObject toJSON() {

        return Json.createObjectBuilder()
                 .add("transactionId", this.getTransactionId())
                 .add("date", this.getDate().toString())
                 .add("from_account", this.getFromAcc())
                 .add("to_account", this.getToAcc())
                 .add("amount", this.getAmount().toString())
                 .build(); 
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    
    public String getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(String fromAcc) {
        this.fromAcc = fromAcc;
    }

    public String getToAcc() {
        return toAcc;
    }

    public void setToAcc(String toAcc) {
        this.toAcc = toAcc;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Userdata [id=" + id + ", accountId=" + accountId + ", firstName=" + firstName + ", balance=" + balance
                + ", comments=" + comments + ", transactionId=" + transactionId + ", date=" + date + "]";
    }

    

    
}
