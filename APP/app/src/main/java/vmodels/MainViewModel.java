package vmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import models.CurrencyModel;
import models.UserModel;

public class MainViewModel extends ViewModel {

    protected MutableLiveData<Boolean> loading = new MutableLiveData<>();
    protected MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public LiveData<Boolean> isLoading(){
        return loading;
    }
    public LiveData<String> hasError (){
        return errorMessage;
    }
}
