package niffler.api;

import niffler.model.SpendJson;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface NifflerSpendApi {
    @POST("/addSpend")
    Call<SpendJson> addSpend(@Body SpendJson spend);

    @DELETE("/deleteSpends")
    Call<Void> deleteSpends(
            @Query("username") String userName,
            @Query("ids") String ids);

    @GET("/spends")
    Call<List<SpendJson>> getUserSpends(@Query("username") String userName);
}