package interfaces;
import models.ResponseStatementModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyAPI {

    @GET("statements/{userID}")
    Call<ResponseStatementModel> listCurrency (@Path("userID") int userID);
}
