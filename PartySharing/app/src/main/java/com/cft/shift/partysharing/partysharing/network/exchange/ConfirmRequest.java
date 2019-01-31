package com.cft.shift.partysharing.partysharing.network.exchange;


import java.io.Serializable;

public class ConfirmRequest implements Serializable {
    /**
     * куда соглашаемся пойти
     */
    private Long eventId;

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }
}
