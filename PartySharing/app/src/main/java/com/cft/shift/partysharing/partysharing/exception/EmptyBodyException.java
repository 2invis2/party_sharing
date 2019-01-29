package com.cft.shift.partysharing.partysharing.exception;

/**
 * Created: samokryl
 * Date: 01.07.18
 * Time: 23:51
 */

public final class EmptyBodyException extends IllegalStateException {

    public EmptyBodyException() {
        super("Body is empty");
    }

}