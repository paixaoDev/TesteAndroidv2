package utils;

import android.util.Log;

import java.util.List;

import interfaces.CurrencyAPI;
import interfaces.LoginAPI;
import models.CurrencyModel;
import models.ErrorModel;
import models.ResponseStatementModel;
import models.UserModel;
import retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class GetCurrency implements Callback<ResponseStatementModel> {

    UserModel userModel;
    private final Response response;

    CurrencyAPI currencyAPI;
    Retrofit retrofit;
    Call<ResponseStatementModel> call;

    public GetCurrency(UserModel userModel, Response response) {
        this.userModel = userModel;
        this.response = response;
        initValues();
    }

    public GetCurrency(Response response) {
        this.response = response;
        initValues();
    }

    void initValues (){
        retrofit = new RetrofitConfig().retrofit;
        currencyAPI = retrofit.create(CurrencyAPI.class);
    }

    public void listCurrency (){
        getCurrency();
    }

    public void listCurrency (UserModel model){
        this.userModel = model;
        getCurrency();
    }

    public void listCurrency (int id){
        getCurrency(id);
    }

    private void getCurrency (){
        call = currencyAPI.listCurrency(userModel.getUserId());
        call.enqueue(this);
    }

    private void getCurrency (int id){
        call = currencyAPI.listCurrency(id);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseStatementModel> call, retrofit2.Response<ResponseStatementModel> response) {
        if(response.isSuccessful()){
            if(response.body() != null){
                Log.d("Async", response.body().toString());
                this.response.onSucess(response.body().getCurrencyModelList());
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseStatementModel> call, Throwable t) {
        this.response.onFailure(t.getMessage());
    }

    public interface Response {
        void onSucess (List<CurrencyModel> userModel);
        void onFailure (String message);
        void onFailure (ErrorModel error);
    }
}
