package com.cft.shift.partysharing.partysharing.network.exchange;



import java.io.Serializable;
public class GetProfileRequest implements Serializable {
    /**
     * id профиля
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
