package com.cft.shift.partysharing.partysharing.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.cft.shift.partysharing.partysharing.exception.EmptyBodyException;

/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 23:55
 */

public final class DefaultCallback<T> implements Callback<T> {

    private final Carry<T> carry;

    public DefaultCallback(final Carry<T> carry) {
        this.carry = carry;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T body = response.body();
        if (body != null) {
            carry.onSuccess(body);
        } else {
            carry.onFailure(new EmptyBodyException());
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        carry.onFailure(t);
    }

}