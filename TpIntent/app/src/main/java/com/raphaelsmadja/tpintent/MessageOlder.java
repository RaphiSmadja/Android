package com.raphaelsmadja.tpintent;

import java.io.Serializable;

/**
 * Created by raphi on 04/10/2017.
 */

public class MessageOlder implements Serializable{
    String message;

    public MessageOlder(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageOlder{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
