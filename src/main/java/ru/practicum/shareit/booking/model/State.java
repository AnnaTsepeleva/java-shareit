package ru.practicum.shareit.booking.model;

import ru.practicum.shareit.exceptions.MethodArgumentException;

public enum State {
    ALL("all"),
    CURRENT("current"),
    PAST("past"),
    FUTURE("future"),
    WAITING("waiting"),
    REJECTED("rejected");

    private String value;

    private State(String value) {
        this.value = value;
    }

    public static State fromStringState(String value) {

        if (value != null) {
            for (State st : State.values()) {
                if (value.equalsIgnoreCase(st.value)) {
                    return st;
                }
            }
        }
        throw new MethodArgumentException("Unknown state: UNSUPPORTED_STATUS");
    }
}
