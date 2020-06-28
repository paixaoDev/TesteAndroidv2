package com.carlosvspaixao.bank;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adapters.StatementAdapter;
import models.CurrencyModel;
import models.UserModel;
import vmodels.CurrencyViewModel;
import vmodels.LoginViewModel;

public class CurrencyActivity extends MainActivity {

    ViewHolder mHolder;
    UserModel userModel;
    CurrencyViewModel currencyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        initValues();
        initAction();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //ToDO - Mensagem de se deseja sair do app ou voltar para o login
    }

    @Override
    public void bind() {
        super.bind();
        currencyViewModel.isLoading().observe(this, this::initLoading);
        currencyViewModel.hasError().observe(this, this::showErroMessage);
        currencyViewModel.getStatements().observe(this, this::initCurrency);
        currencyViewModel.getUser().observe(this, this::initUser);
    }

    @Override
    public void unbind() {
        super.unbind();
        currencyViewModel.isLoading().removeObservers(this);
        currencyViewModel.hasError().removeObservers(this);
        currencyViewModel.getUser().removeObservers(this);
        currencyViewModel.getStatements().removeObservers(this);
    }

    void initValues (){
        mHolder = new ViewHolder();
        currencyViewModel = new ViewModelProvider(this).get(CurrencyViewModel.class);
    }

    void initAction (){
        mHolder.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToDo - Criar opção de logout
            }
        });
    }

    void initUser (UserModel userModel){
        Log.d("Async", userModel.toString());
        mHolder.txtName.setText(userModel.getName());
        mHolder.txtAccount.setText(userModel.getAgency());
        mHolder.txtBalance.setText(String.valueOf(userModel.getBalance()));
    }

    void initCurrency (List<CurrencyModel> currencyModels){
        StatementAdapter statementAdapter = new StatementAdapter(activity, currencyModels);
        mHolder.currencyRecycler.setAdapter(statementAdapter);
        mHolder.currencyRecycler.setLayoutManager(new LinearLayoutManager(activity, RecyclerView.VERTICAL, false));
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
    //Mostra um erro na tela
    void showErroMessage (String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    class ViewHolder{
        TextView txtName, txtAccount, txtBalance;
        ImageButton btnLogout;
        RecyclerView currencyRecycler;
        public ViewHolder (){
            txtName = findViewById(R.id.txt_name);
            txtAccount = findViewById(R.id.txt_conta);
            txtBalance = findViewById(R.id.txt_value);
            btnLogout = findViewById(R.id.btn_logout);
            currencyRecycler = findViewById(R.id.recycler_currency);
        }
    }
}