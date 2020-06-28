package com.carlosvspaixao.bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import models.ErrorModel;
import models.LoginModel;
import models.UserModel;
import utils.LoginUser;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    Activity activity;
    Toast loadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
    }

    public String getStringResource (int ID){
        return activity.getResources().getString(ID);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bind();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void bind (){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void unbind (){}

}