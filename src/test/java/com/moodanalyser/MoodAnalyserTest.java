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
        try {
            moodAnalyser=new MoodAnalyser("I am in Sad Mood");
            Assert.assertEquals("Sad", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 1.2 : Given I am in Happy Mood message in Constructor Should Return Happy */
    @Test
    public void givenMessageInConstructor_WhenContainHappyMood_ShouldReturnHappy() {
        try {
            moodAnalyser=new MoodAnalyser("I am in Happy Mood");
            Assert.assertEquals("Happy", moodAnalyser.analyseMood());
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 3.1 : Given NULL Mood Should Throw MoodAnalysisException */
    @Test
    public void givenMessageInConstructor_WhenNull_ShouldThrowMoodAnalyserException() {
        try {
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_NULL,e.type);
        }
    }

    /* T.C. 3.2 : Given Empty Mood Should Throw MoodAnalysisException indicating Empty Mood */
    @Test
    public void givenMessageInConstructor_WhenEmpty_ShouldThrowMoodAnalyserException() {
        try {
            moodAnalyser=new MoodAnalyser("");
            moodAnalyser.analyseMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY, e.type);
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

    /* T.C. 5.1 : Given MoodAnalyser When Proper Return MoodAnalyser Object */
    @Test
    public void givenMoodAnalyzerUsingParameterizedConstructor_whenProper_shouldReturnObject() {
        try {
            MoodAnalyser reflectionMoodObject = MoodAnalyserFactory.createMoodAnalyser("I am in Happy Mood");
            Assert.assertEquals(new MoodAnalyser("I am in Happy Mood"), reflectionMoodObject);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 6.1 : Given Happy Message Using Reflection When Proper Should Return HAPPY Mood */
    @Test
    public void givenProperMethodName_WhenInvoked_ShouldReturnHappy() {
        try {
            MoodAnalyser moodObject=MoodAnalyserFactory.createMoodAnalyser("I am in Happy Mood");
            String mood=MoodAnalyserFactory.invokeMethod(moodObject,"analyseMood");
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    /* T.C. 6.2 : Given Happy Message When Improper Method Should Throw MoodAnalysisException */
    @Test
    public void givenMethodName_WhenNotProper_ShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyser moodObject=MoodAnalyserFactory.createMoodAnalyser("I am in Happy Mood");
            MoodAnalyserFactory.invokeMethod(moodObject,"analyseMood1");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    /* T.C. 7.1 : Set Happy Message with Reflector Should Return HAPPY */
    @Test
    public void givenFieldNameAndItsValue_WhenProper_ShouldReturnValue() {
        MoodAnalyser moodObject=MoodAnalyserFactory.createMoodAnalyser();
        String mood=MoodAnalyserFactory.setFieldValue(moodObject, "I am in Happy Mood","mood");
        Assert.assertEquals("Happy",mood);
    }

    /* T.C. 7.2 : Set Field When Improper Should Throw Exception with No Such Field*/
    @Test
    public void givenFieldNameAndItsValue_WhenFieldNotFound_ShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyser moodObject=MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldValue(moodObject,"Happy","mood1");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD, e.type);
        }
    }

    /* T.C. 7.3 : Setting Null Message with Reflector Should Throw Exception */
    @Test
    public void givenFieldNameAndNullValue_ShouldThrowMoodAnalyzerException() {
        try {
            MoodAnalyser moodObject=MoodAnalyserFactory.createMoodAnalyser();
            MoodAnalyserFactory.setFieldValue(moodObject,null,"mood");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE, e.type);
        }
    }
}

