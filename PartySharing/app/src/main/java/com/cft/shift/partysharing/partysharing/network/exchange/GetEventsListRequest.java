package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;
import java.util.ArrayList;

public class GetEventsListRequest implements Serializable {

    ArrayList<Long> attend;
    public GetEventsListRequest(ArrayList attend){
        this.attend = ( ArrayList<Long>)attend.clone();

    }


}
