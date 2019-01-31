package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;
import java.util.List;

public class FeedResponse implements Serializable {

    public static class Pending  implements Serializable {
        /**
         * число уведомлений
         */
        private int count;

        public void setCount(int count) {
            this.count = count;
        }

        public void setData(List<EventPreview> data) {
            this.data = data;
        }

        public int getCount() {
            return count;
        }

        public List<EventPreview> getData() {
            return data;
        }

        /**
         * превью уведомлений
         */
        private List<EventPreview> data;
    }


    public static class Feed implements Serializable {
        /**
         * число событий в ленте
         */
        private int count;
        /**
         * Превью событий в ленте
         */
        private List<EventPreview> data;

        public int getCount() {
            return count;
        }

        public List<EventPreview> getData() {
            return data;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setData(List<EventPreview> data) {
            this.data = data;
        }
    }

    /**
     * уведомления
     */
    Pending pending;

    public void setPending(Pending pending) {
        this.pending = pending;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public Pending getPending() {
        return pending;
    }

    public Feed getFeed() {
        return feed;
    }

    /**
     * лента
     */
    Feed feed;
}
