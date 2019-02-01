package com.cft.shift.partysharing.partysharing.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.cft.shift.partysharing.partysharing.types.Constants;

public class IdSaver {

    public static void putId(Long id, Context context) {
        SharedPreferences sp =  PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(Constants.ID_PREFERENSE, id);
        editor.apply();
    }

    public static Long getId(Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getLong("ExactTime", 0);
    }

}
