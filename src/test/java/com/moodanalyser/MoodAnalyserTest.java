package com.moodanalyser;

import com.moodanalyserexception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    private MoodAnalyser moodAnalyser;

    /* TC 1.1 : Given I am in Sad Mood message in Constructor Should Return Sad */
    @Test
    public void givenMessageInConstructor_WhenContainSadMood_ShouldReturnSad() {
        moodAnalyser=new MoodAnalyser("I am in Sad Mood");
        try {
            Assert.assertEquals("Sad", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 1.2 : Given I am in Happy Mood message in Constructor Should Return Happy */
    @Test
    public void givenMessageInConstructor_WhenContainHappyMood_ShouldReturnHappy() {
        moodAnalyser=new MoodAnalyser("I am in Happy Mood");
        try {
            Assert.assertEquals("Happy", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 3.1 : Given NULL Mood Should Throw MoodAnalysisException */
    @Test
    public void givenMessageInConstructor_WhenNull_ShouldThrowMoodAnalyserException() {
        moodAnalyser = new MoodAnalyser();
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.IS_NULL,e.type);
        }
    }

    /* T.C. 3.2 : Given Empty Mood Should Throw MoodAnalysisException indicating Empty Mood */
    @Test
    public void givenMessageInConstructor_WhenEmpty_ShouldThrowMoodAnalyserException() {
        moodAnalyser=new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.IS_EMPTY, e.type);
        }
    }
}

