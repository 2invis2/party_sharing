package com.cft.shift.partysharing.partysharing.features.profile.presentation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.cft.shift.partysharing.partysharing.features.MvpPresenter;
import com.cft.shift.partysharing.partysharing.features.profile.domain.ProfileInteractor;
import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;
import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;


public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private final ProfileInteractor profileInteractor;

    ProfilePresenter(ProfileInteractor profileInteractor) {
        this.profileInteractor=profileInteractor;
    }

    protected void onViewMyProfile(){
        getProfile();
    }

    //Показывает профиль на экране
    private void getProfile () {
        //Нужно где то брать(тоесть где-то в шаред преференс хранится) инфу о проифиле
        GetProfileRequest myProfile=null;
        profileInteractor.loadProfile(new Carry<GetProfileResponse>() {
            @Override
            public void onSuccess(GetProfileResponse result) {
                ArrayList<String> interests = new ArrayList<>();
                String[] strings = result.getInterests().split(",");
                interests = new ArrayList<>(Arrays.asList(strings));
                Bitmap image = convertToImage(result.getImage());
                final Profile profile = new Profile(result.getFirstName(),result.getLastName(),result.getAge(),result.getLocation(),interests,image);
                view.showProfile(profile);
            }
            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Problems with profile!");
            }
        },myProfile);

    }
    public void  getEventPreviews( ) {
        profileInteractor.loadEvents(new Carry<GetAllEventsResponse>() {
            @Override
            public void onSuccess(GetAllEventsResponse result) {
                view.showEventsPreviw(result.getCount(),result.getEvents());
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError("You Have Problems with eventspreviw");

            }
        });

    }

    private static Bitmap convertToImage(String stringbase64){
        String[] strings = stringbase64.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpeg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }
        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        return bitmap;
    }

}
