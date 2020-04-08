package com.moodanalyser;

import com.moodanalyserexception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

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
        moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.IS_NULL,e.type);
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
    }

    /** Reflection */
    @Test
    public void givenMessageInConstructorUsingReflection_WhenContainsAnyMood_ShouldReturnHappy() {
        try {
            Constructor<?> constructor = Class.forName("com.moodanalyser.MoodAnalyser").getConstructor(String.class);
            MoodAnalyser moodAnalyser = (MoodAnalyser) constructor.newInstance("I am in Happy Mood");
            String mood = moodAnalyser.analyseMood();
            Assert.assertEquals("Happy", mood);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* T.C. 4.1 : Given MoodAnalyser Class Name Should Return MoodAnalyser Object */
    @Test
    public void givenMoodAnalyserClassUsingDefaultConstructor_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyser reflectionMoodObject = MoodAnalyserFactory.createMoodAnalyser();
            Assert.assertEquals(new MoodAnalyser(),reflectionMoodObject);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 4.2 : Given Class Name When Improper Should Throw MoodAnalyserException */
    @Test
    public void givenClassName_WhenImproper_ShouldReturnMoodAnalyserException() {
        try {
            MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalysis",String.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    /* T.C. 4.3 : Given Class When Constructor Not Proper Should Throw MoodAnalyserException */
    @Test
    public void givenClassName_WhenConstructorNotProper_ShouldReturnMoodAnalyserException() {
        try {
            MoodAnalyserFactory.getConstructor("com.moodanalyser.MoodAnalyser",Integer.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}

