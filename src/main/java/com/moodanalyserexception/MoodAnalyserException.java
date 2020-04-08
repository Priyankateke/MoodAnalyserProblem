package com.moodanalyserexception;

public class MoodAnalyserException extends RuntimeException {
    public enum ExceptionType {
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,NO_SUCH_FIELD,METHOD_INVOCATION_ISSUE;
    }

    public final ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}
