package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;
import java.util.List;

public class GetAllEventsResponse implements Serializable {
    /**
     * число записей
     */
    int count;

    public int getCount() {
        return count;
    }

    public List<EventPreview> getEvents() {
        return events;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setEvents(List<EventPreview> events) {
        this.events = events;
    }

    /**
     * все мероприятия
     */
    List<EventPreview> events;
}
