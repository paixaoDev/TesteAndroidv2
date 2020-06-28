package utils;

import android.util.Log;

import interfaces.LoginAPI;
import models.ErrorModel;
import models.LoginModel;
import models.UserAccountModel;
import models.UserModel;
import retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class LoginUser implements Callback<UserAccountModel> {

    private LoginModel loginModel;
    private final Response response;

    LoginAPI loginAPI;
    Retrofit retrofit;
    Call<UserAccountModel> call;

    public LoginUser(LoginModel loginModel, Response response) {
        this.loginModel = loginModel;
        this.response = response;
        initValues();
    }

    public LoginUser(Response response) {
        this.response = response;
        initValues();
    }

    public void login (){
        callLogin();
    }

    public void login (LoginModel model){
        this.loginModel = model;
        callLogin();
    }

    public void login (String user, String password){
        callLogin(user, password);
    }

    //Inicia valores necessarios para realizar o login
    private void initValues (){
        retrofit = new RetrofitConfig().retrofit;
        loginAPI = retrofit.create(LoginAPI.class);
    }

    private void callLogin (){
        call = loginAPI.login(loginModel);
        call.enqueue(this);
    }

    private void callLogin (String name, String password){
        call = loginAPI.login(name, password);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<UserAccountModel> call, retrofit2.Response<UserAccountModel> response) {
        if(response.isSuccessful()){
            if(response.body() != null){
                if(response.body().getUserAccount() != null){
                    //ToDo - Salvar na room
                    this.response.onSucess(response.body().getUserAccount());
                }
                else if(response.body().getError() != null){
                    this.response.onFailure(response.body().getError());
                }
            }else{
                this.response.onFailure("Erro ao obter dados");
            }

        }else{
            this.response.onFailure(response.message());
        }
    }

    @Override
    public void onFailure(Call<UserAccountModel> call, Throwable t) {
        this.response.onFailure(t.getMessage());
    }

    public interface Response {
        void onSucess (UserModel userModel);
        void onFailure (String message);
        void onFailure (ErrorModel error);
    }
}
