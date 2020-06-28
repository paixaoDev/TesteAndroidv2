package com.carlosvspaixao.bank;


import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vmodels.LoginViewModel;

public class LoginActivity extends MainActivity {


    ViewHolder mHolder;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initValues();
        initActions();
    }

    @Override
    public void bind() {
        Log.d("Binding", "Bing succefull");
        loginViewModel.isLoading().observe(this, this::initLoading);
        loginViewModel.hasError().observe(this, this::showErroMessage);
        loginViewModel.checkPassword().observe(this, this::putErrorMessage);
        loginViewModel.isLogged().observe(this, this::goToCurrency);
    }

    @Override
    public void unbind() {
        loginViewModel.isLoading().removeObservers(this);
        loginViewModel.isLogged().removeObservers(this);
        loginViewModel.hasError().removeObservers(this);
        loginViewModel.checkPassword().removeObservers(this);
    }

    public void initValues() {
        mHolder = new ViewHolder();
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    public void initActions() {
        mHolder.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mHolder.edtUser.getText().toString();
                String password = mHolder.edtPassword.getText().toString();
                //"test_user","Test@1"
                loginViewModel.loginUser(user, password);
            }
        });
    }

    //Coloca a tela para carregar
    void initLoading (boolean loading){
        if(loading){
            if(loadingMessage == null)
                loadingMessage = Toast.makeText(this, "Carregando", Toast.LENGTH_LONG);
            loadingMessage.show();
        }else{
            loadingMessage.cancel();
        }
    }

    void putErrorMessage (int errorMessageID){
        Log.e("Message", "Colocando erro na senha: " + errorMessageID);
        if(errorMessageID > 0){
            mHolder.edtPassword.setError(getStringResource(errorMessageID));
        }
    }

    void showErroMessage (String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    void goToCurrency (boolean logged){
        Intent intent = new Intent(activity, CurrencyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    class ViewHolder{
        EditText edtUser, edtPassword;
        Button loginButton;

        public ViewHolder (){
            edtUser = findViewById(R.id.edt_user);
            edtPassword = findViewById(R.id.edt_password);
            loginButton = findViewById(R.id.btn_login);
        }
    }
}