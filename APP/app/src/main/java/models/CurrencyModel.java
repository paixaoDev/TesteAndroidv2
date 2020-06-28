package models;

import com.google.gson.annotations.SerializedName;

public class CurrencyModel {

    @SerializedName("title")
    private String tittle;
    private String desc;
    private String date;
    private float value;


    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CurrencyModel{" +
                "tittle='" + tittle + '\'' +
                ", desc='" + desc + '\'' +
                ", date='" + date + '\'' +
                ", value=" + value +
                '}';
    }
}
