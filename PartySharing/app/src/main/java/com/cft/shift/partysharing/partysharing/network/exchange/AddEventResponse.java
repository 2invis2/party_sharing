package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;

public class AddEventResponse implements Serializable {
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    /**
     * id мероприятия
     */
    Long id;

}
