package models;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {

    @Nullable
    private Integer userId;
    @Nullable
    private String name;
    @Nullable
    private String bankAccount;
    @Nullable
    private String agency;
    @Nullable
    private Float balance;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    boolean isValid (){
        boolean result = true;

        if(this.userId <= 0){
            return false;
        }

        if(this.name == null){
            return false;
        }

        if(this.name.equals("null")){
            return false;
        }

        if(this.name.isEmpty()){
            return false;
        }

        return result;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", agency='" + agency + '\'' +
                ", balance=" + balance +
                '}';
    }
}
