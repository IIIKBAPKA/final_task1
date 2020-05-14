package api;

import api.Params;
import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {
    @POST("/1/boards")
    Call<Params> createBoard(@Body Params params, @Query("name") String name);

    @POST("/1/lists")
    Call<Params> createList(@Body Params params, @Query("name") String name, @Query("idBoard") String idBoard);

    @POST("/1/cards")
    Call<Params> createCard(@Body Params params, @Query("idList") String idList);

    @PUT("/1/boards/{id}/members/{idMember}")
    Call<Params> addMember(@Path("id") String id, @Path("idMember") String idMember, @Query("key") String key, @Query("token") String token, @Query("type") String type);

    @PUT("/1/lists/{id}/closed")
    Call<Params> archiveList(@Path("id") String id, @Query("key") String key, @Query("token") String token, @Query("value") String value);

    @POST("/1/cards/{id}/labels")
    Call<Params> createLabelCard(@Body Params params, @Path("id") String id, @Query("color") String color);

    @GET("/1/boards/{id}/members")
    Call<Params> getMember(@Path("id") String id, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/boards/{id}/members/{idMember}")
    Call<Params> deleteMember(@Path("id") String id, @Path("idMember") String idMember, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/cards/{id}/idLabels/{idLabel}")
    Call<Params> deleteLabel(@Path("id") String id, @Path("idLabel") String idLabel, @Query("key") String key, @Query("token") String token);

    @DELETE("/1/boards/{id}")
    Call<Params> deleteBoard(@Path("id") String id, @Query("key") String key, @Query("token") String token);
}