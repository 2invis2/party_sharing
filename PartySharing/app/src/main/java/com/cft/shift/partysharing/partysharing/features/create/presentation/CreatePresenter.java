package com.cft.shift.partysharing.partysharing.features.create.presentation;

import com.cft.shift.partysharing.partysharing.ImageCache;
import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.create.domain.CreateInteractor;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.AddEventResponse;
import com.cft.shift.partysharing.partysharing.types.InterestType;

public class CreatePresenter extends MvpPresenter<CreateActivityView>{

    private CreateInteractor interactor;

    private AddEventRequest request = new AddEventRequest();

    CreatePresenter(CreateInteractor interactor) {
        this.interactor = interactor;
    }

    void setInterest(InterestType interest) {
        request.setCategory(interest);
    }

    void setEventInfo(String name, String location, String address,
                          String date, String desc) {
        request.setName(name);
        request.setLocation(location);
        request.setAddress(address);
        request.setDate(date);
        request.setDescription(desc);
    }

    public void setImage(String image) {
        request.setImage(image);
    }

    public void create(Long id) {
        final String image = request.getImage();
        request.setImage("");
        interactor.create(id, request, new Carry<AddEventResponse>() {
            @Override
            public void onSuccess(AddEventResponse result) {
                ImageCache.putEventImage(result.getId(), image);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }
}
