package com.moodanalyserexception;

public class MoodAnalyserException extends RuntimeException {
    public enum ExceptionType {
        IS_NULL,IS_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD;
    }

    public final ExceptionType type;

    public MoodAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type=type;
    }
}
