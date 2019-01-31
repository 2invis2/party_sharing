package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;


public class RegisterResponse implements Serializable {
    /**
     * id нового пользователя
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
