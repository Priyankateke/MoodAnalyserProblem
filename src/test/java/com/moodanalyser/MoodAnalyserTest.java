package com.moodanalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser=new MoodAnalyser();

    /* TC 1.1 : Given I am in Sad Mood message in Constructor Should Return Sad */
    @Test
    public void givenMessageInConstructor_WhenContainSadMood_ShouldReturnSad() {
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in Sad Mood");
        Assert.assertEquals("Sad",moodAnalyser.analyseMood());
    }

    /* T.C. 1.2 : Given I am in Happy Mood message in Constructor Should Return Happy */
    @Test
    public void givenMessageInConstructor_WhenContainHappyMood_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in Happy Mood");
        Assert.assertEquals("Happy",moodAnalyser.analyseMood());
    }

    /* T.C. 2.1 : Given Null Mood Should Return Happy */
    @Test
    public void givenMessageInConstructor_WhenNull_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("Happy", moodAnalyser.analyseMood());
    }
}

