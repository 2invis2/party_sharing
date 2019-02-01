package com.cft.shift.partysharing.partysharing.features.register.presentation;

import android.app.Activity;
import android.content.Intent;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.feed.presentation.FeedActivity;
import com.cft.shift.partysharing.partysharing.features.register.domain.RegisterInteractor;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.RegisterResponse;
import com.cft.shift.partysharing.partysharing.util.IdSaver;

public class RegisterPresenter extends MvpPresenter<RegisterView> {

    RegisterInteractor interactor;

    RegisterRequest request = new RegisterRequest();

    public RegisterPresenter(RegisterInteractor interactor) {
        this.interactor = interactor;
    }

    public void setSelectedInterests(String selectedInterests) {
        request.setInterests(selectedInterests);
    }

    public void setName(String name) {
        request.setFirstName(name);
    }

    public void setLastname(String lastname) {
        request.setLastName(lastname);
    }

    public void setAge(int age) {
        request.setAge(age);
    }

    public void setLocation(String location) {
        request.setLocation(location);
    }

    public void setImage(String image) {
        request.setImage(image);
    }

    void register(final Activity context) {
        interactor.register(request, new Carry<RegisterResponse>() {
            @Override
            public void onSuccess(RegisterResponse result) {
                IdSaver.putId(result.getId(), context);
                Intent myIntent = new Intent(context, FeedActivity.class);
                context.startActivity(myIntent);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("Registration error");
            }
        });
    }

}
