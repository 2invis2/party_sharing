package com.cft.shift.partysharing.partysharing.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Converter {

    public static String bitmapToBase64(Bitmap bitmap) {
        Bitmap scaled = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        scaled.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.URL_SAFE);
    }

    public static Bitmap base64ToBitmap(String base64) {
        if (base64 == null || base64.isEmpty()) {
            return null;
        }
        byte[] decodedString = Base64.decode(base64, Base64.URL_SAFE);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

}
