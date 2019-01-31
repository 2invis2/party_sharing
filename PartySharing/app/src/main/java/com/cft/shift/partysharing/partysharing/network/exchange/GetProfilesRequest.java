package com.cft.shift.partysharing.partysharing.network.exchange;


import java.io.Serializable;
import java.util.List;
public class GetProfilesRequest implements Serializable {
    /**
     * айдишники профилей
     */
    private List<Long> ids;

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getIds() {
        return ids;
    }
}
