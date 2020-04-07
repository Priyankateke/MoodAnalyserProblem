package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser=new MoodAnalyser();

    /* TC 1.1 : Given I am in Sad Mood message Should Return SAD */
    @Test
    public void givenMood_WhenSad_ShouldReturnSad() {
        Assert.assertEquals("Sad",moodAnalyser.analyseMood("I am in Sad Mood"));
    }

    /* T.C. 1.2 : Given I am in Any Mood message Should Return HAPPY */
    @Test
    public void givenMood_WhenHappy_ShouldReturnHappy() {
        Assert.assertEquals("Happy",moodAnalyser.analyseMood("I am in any Mood"));
    }
}
