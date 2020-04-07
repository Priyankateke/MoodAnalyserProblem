package com.moodanalyser;

public class MoodAnalyser {
    private String message;

    /* Default Constructor*/
    public MoodAnalyser() {
    }

    /* Parameterized Constructor*/
    public MoodAnalyser(String message) {
        this.message=message;
    }

    /* If Message contains "Sad" returns "Sad" else return Happy */
    public String analyseMood() {
        try {
            if(message.contains("Sad"))
                return "Sad";
            return "Happy";
        } catch (NullPointerException e) {
            e.printStackTrace();
            return "Happy";
        }

    }
}
