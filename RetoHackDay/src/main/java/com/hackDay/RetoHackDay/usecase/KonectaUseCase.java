package com.hackDay.RetoHackDay.usecase;

import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class KonectaUseCase {

    public String url = "https://mqjl9s6vf4.execute-api.eu-west-1.amazonaws.com/prod/v1/hackday/private/event";

    public String congnitoUrl = "https://hackday-22-prod.auth.eu-west-1.amazoncognito.com/oauth2/token";


    public Map<String, String> formData = new HashMap<>();

    public String getData() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String token = getToken(congnitoUrl);
        JSONObject json = new JSONObject(token);
        Request request = new Request.Builder()
                .addHeader("Authorization", "Bearer " + json.get("access_token"))
                .get()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code()==200){
            System.out.println("Get Data Successful!");
        }
        return response.body().string();

    }

    private String getToken(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String valueToEncode = "129ciog6ih4ojnlaaf8d3rlosu:13rvib77c8damevnjav3mgg5sjd11io0npk422jctgjlanjjvvle";
        String encodedString = "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
        formData.put("grant_type", "client_credentials");

        RequestBody body = new FormBody.Builder()
                .add("grant_type", "client_credentials").build();
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", encodedString)
                .post(body)
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (response.code()==200){
            System.out.println("Authorization Successful!");
        }
        return response.body().string();
    }


}
