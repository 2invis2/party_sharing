package com.cft.shift.partysharing.partysharing.features.profile.data;

import com.cft.shift.partysharing.partysharing.network.Carry;
import com.cft.shift.partysharing.partysharing.network.DefaultCallback;
import com.cft.shift.partysharing.partysharing.network.exchange.GetAllEventsResponse;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileRequest;
import com.cft.shift.partysharing.partysharing.network.exchange.GetProfileResponse;

public class ProfileDataSourceImp implements ProfileDataSource {
    private final ProfileApi profileApi;

    public ProfileDataSourceImp(ProfileApi profileApi) {
        this.profileApi = profileApi;
    }
    @Override
    public void getProfile(final Carry<GetProfileResponse> carry, GetProfileRequest getProfileRequest) {
         profileApi.getProfile(getProfileRequest).enqueue(new DefaultCallback<GetProfileResponse>(carry));
    }
    @Override
    public void getEvents(Carry<GetAllEventsResponse> carry) {
        profileApi.getEventList().enqueue(new DefaultCallback<GetAllEventsResponse>(carry));
    }
}

      /*  private Bitmap convertToImage(String stringbase64){
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

        }*/

