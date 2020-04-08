package com.moodanalyser;

import com.moodanalyserexception.MoodAnalyserException;

public class MoodAnalyser {
    private String mood;

    /* Default Constructor*/
    public MoodAnalyser() {
        mood="default";
    }

    /* Parameterized Constructor*/
    public MoodAnalyser(String mood) {
        this.mood=mood;
    }

    /* If Message contains "Sad" returns "Sad" else return Happy */
    public String analyseMood() {
        try {
            if(mood.contains("Sad")) {
                return "Sad";
            } else if(mood.isEmpty()) {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.IS_EMPTY,"Mood Cannot be Empty, Pass Valid Mood");
            }
            return "Happy";
        } catch (NullPointerException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.IS_NULL,"Mood Cannot be Null, Pass Valid Mood");
        }
    }

    /* Comparing two objects*/
    @Override
    public boolean equals(Object another) {
        if(this.mood.equals(((MoodAnalyser)another).mood))
            return true;
        return false;
    }
}
