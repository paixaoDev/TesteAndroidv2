package vmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.carlosvspaixao.bank.R;

import models.ErrorModel;
import models.LoginModel;
import models.UserModel;
import utils.LoginUser;
import utils.VerifyPasswordByRules;

public class LoginViewModel extends MainViewModel {
    //Mutable Values
    private MutableLiveData<Integer> passwordMessage = new MutableLiveData<>();
    private MutableLiveData<Boolean> makeLogin = new MutableLiveData<>();

    //region Check Password
    public LiveData<Integer> checkPassword(){
        return passwordMessage;
    }

    public boolean checkPassword (String password){
        return verifyPassword(password);
    }

    boolean verifyPassword (String password){

        if(!VerifyPasswordByRules.verifyPassword(password, VerifyPasswordByRules.RULE_SPECIAL_CHARACTER)){
            passwordMessage.postValue(R.string.error_password_special_chracter);
            return false;
        }


        if(!VerifyPasswordByRules.verifyPassword(password, VerifyPasswordByRules.RULE_ALPHANUMERIC)){
            passwordMessage.postValue(R.string.error_password_alphanumeric);
            return false;
        }

        if(!VerifyPasswordByRules.verifyPassword(password, VerifyPasswordByRules.RULE_LETTERS)){
            passwordMessage.postValue(R.string.error_password_letter);
            return false;
        }

        return true;
    }
    //endregion

    //region Login
    public LiveData<Boolean> isLogged(){
        return makeLogin;
    }

    public void loginUser (String user, String password){
        if(checkPassword(password)){
            loadUser(user, password);
        }
    }

    private void loadUser (String _user, String _password){
        loading.postValue(true);

        LoginUser loginUser = new LoginUser(new LoginModel(_user, _password),new LoginUser.Response() {
            @Override
            public void onSucess(UserModel userModel) {
                loading.postValue(false);
                makeLogin.postValue(true);
            }

            @Override
            public void onFailure(String message) {
                loading.postValue(false);
                makeLogin.postValue(false);
                errorMessage.postValue(message);
            }

            @Override
            public void onFailure(ErrorModel error) {
                loading.postValue(false);
                makeLogin.postValue(false);
                errorMessage.postValue(error.getMessage());
            }
        });
        loginUser.login();
    }
    //endregion
}
