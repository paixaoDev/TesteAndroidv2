package models;
import androidx.annotation.Nullable;

public class UserAccountModel{

    @Nullable
    private UserModel userAccount;
    @Nullable
    private ErrorModel error;

    public UserModel getUserAccount() {
        if(!userAccount.isValid()){
            return null;
        }

        return userAccount;
    }
    public void setUserAccount(UserModel userAccount) {
        this.userAccount = userAccount;
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
        return "UserAccountModel{" +
                "userAccount=" + userAccount +
                ", error=" + error +
                '}';
    }
}
