package com.cft.shift.partysharing.partysharing;

import android.util.LongSparseArray;

public class ImageCache {
    private static LongSparseArray<String> profiles = new LongSparseArray<>();
    private static LongSparseArray<String> events = new LongSparseArray<>();

    public static void putProfileImage(Long id, String profileImage) {
        profiles.put(id, profileImage);
    }

    public static void putEventImage(Long id, String eventImage) {
        events.put(id, eventImage);
    }

    public static String getProfileImage(Long id) {
        return profiles.get(id);
    }

    public static String getEventImage(Long id) {
        return events.get(id);
    }
}
