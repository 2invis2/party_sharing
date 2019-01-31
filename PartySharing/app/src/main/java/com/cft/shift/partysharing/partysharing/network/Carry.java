package com.cft.shift.partysharing.partysharing.network;

import com.cft.shift.partysharing.partysharing.features.profile.domain.model.Profile;

/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 23:04
 */

public interface Carry<T> {

    Profile onSuccess(T result);

    void onFailure(Throwable throwable);

}
