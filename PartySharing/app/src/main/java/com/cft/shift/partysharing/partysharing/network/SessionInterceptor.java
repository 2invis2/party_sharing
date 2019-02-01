package com.cft.shift.partysharing.partysharing.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class SessionInterceptor implements Interceptor {


    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        Request newRequest;

        newRequest = request.newBuilder()
                .addHeader("Authorization","1")
                .build();
        return chain.proceed(newRequest);
    }
}
