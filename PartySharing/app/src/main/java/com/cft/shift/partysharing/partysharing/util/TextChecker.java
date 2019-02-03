package com.cft.shift.partysharing.partysharing.util;

import android.widget.EditText;

public class TextChecker {

    public static boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() <= 0;
    }

}
