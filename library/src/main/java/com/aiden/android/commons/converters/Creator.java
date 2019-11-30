package com.aiden.android.commons.converters;

@SuppressWarnings("WeakerAccess") // Public API
public interface Creator<IN, OUT> {

    OUT create(IN obj);

}
