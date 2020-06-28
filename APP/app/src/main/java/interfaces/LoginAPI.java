package interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import models.LoginModel;
import models.UserAccountModel;
import models.UserModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginAPI {


    @POST("login")
    Call<UserAccountModel> login (@Body LoginModel body);


    @FormUrlEncoded
    @POST("login")
    Call<UserAccountModel> login (@Field("user") String user,
                                  @Field("password") String password);
}
