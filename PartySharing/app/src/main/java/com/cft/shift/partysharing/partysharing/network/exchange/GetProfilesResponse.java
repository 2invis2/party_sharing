package com.cft.shift.partysharing.partysharing.network.exchange;


import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;

import java.io.Serializable;
import java.util.List;

public class GetProfilesResponse implements Serializable {
    /**
     * число профилей
     */
    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public int getCount() {
        return count;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    /**
     * профили
     */
    private List<Profile> profiles;
}
