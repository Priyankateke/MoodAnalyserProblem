package com.moodanalyser;

public class MoodAnalyser {

    /* If Message contains "Sad" returns "Sad" else return Happy */
    public String analyseMood(String message) {
        if(message.contains("Sad"))
            return "Sad";
        return "Happy";
    }
}
