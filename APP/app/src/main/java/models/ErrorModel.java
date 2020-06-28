package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorModel {

    private int code;
    private String message;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    boolean isValid (){
        boolean result = true;

        if(this.code <= 0){
            return false;
        }

        if(this.message == null){
            return false;
        }

        if(this.message.equals("null")){
            return false;
        }

        if(this.message.isEmpty()){
            return false;
        }

        return result;
    }

    @Override
    public String toString() {
        return "ErrorModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
