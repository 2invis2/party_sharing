package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;

public class EventPreview implements Serializable {
    /**
     * Event id
     */
    private Long id;
    /**
     * Event name
     */
    private String name;
    /**
     * Превью картинки в кодировке base64
     */
    private String preview;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreview() {
        return preview;
    }
}
