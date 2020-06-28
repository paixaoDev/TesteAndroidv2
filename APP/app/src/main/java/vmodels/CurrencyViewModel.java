package vmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import models.CurrencyModel;
import models.ErrorModel;
import models.UserModel;
import utils.GetCurrency;
import utils.LoginUser;

public class CurrencyViewModel extends MainViewModel {



    protected MutableLiveData<UserModel> user;
    protected MutableLiveData<List<CurrencyModel>> currency;

    public LiveData<UserModel> getUser(){
        if(user == null){
            user = new MutableLiveData<UserModel>();
            getUserModel();
        }
        return user;
    }

    public void getUserModel (){
        //ToDo - Pegar User da Room
    }

    public LiveData<List<CurrencyModel>> getStatements(){
        if(currency == null){
            currency = new MutableLiveData<List<CurrencyModel>>();
            getCurrency();
        }
        return currency;
    }

    public void getCurrency (){
        loadCurrency();
    }

    private void loadCurrency (){
        loading.postValue(true);

        GetCurrency getCurrency = new GetCurrency( new GetCurrency.Response() {
            @Override
            public void onSucess(List<CurrencyModel> userModel) {
                currency.postValue(userModel);
            }

            @Override
            public void onFailure(String message) {
                errorMessage.postValue(message);
            }

            @Override
            public void onFailure(ErrorModel error) {
                errorMessage.postValue(error.getMessage());
            }
        });
        getCurrency.listCurrency(1);
    }
}
