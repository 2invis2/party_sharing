package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;

public class InviteRequest implements Serializable {
    /**
     * кого приглашаем
     */
    private Long userId;
    /**
     * куда приглашаем
     */
    private Long eventId;

    public Long getUserId() {
        return userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
