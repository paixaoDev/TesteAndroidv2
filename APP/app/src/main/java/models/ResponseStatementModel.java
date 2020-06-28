package models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseStatementModel {

    @SerializedName("statementList")
    private List<CurrencyModel> currencyModelList;
    private ErrorModel error;

    public List<CurrencyModel> getCurrencyModelList() {
        return currencyModelList;
    }

    public void setCurrencyModelList(List<CurrencyModel> currencyModelList) {
        this.currencyModelList = currencyModelList;
    }

    public ErrorModel getError() {
        if(!error.isValid()){
            return null;
        }

        return error;
    }

    public void setError(ErrorModel error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseStatementModel{" +
                "currencyModelList=" + currencyModelList +
                ", error=" + error +
                '}';
    }
}
