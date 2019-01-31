package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;

public class AcceptRequest implements Serializable {
    /**
     * id куда принимаем заявку
     */
    private Long eventId;
    /**
     * от кого принимаем заявку
     */
    private Long userId;

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getUserId() {
        return userId;
    }
}
