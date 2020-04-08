package com.moodanalyser;

import com.moodanalyserexception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    //For Default Constructor
    public static MoodAnalyser createMoodAnalyser() {
        try {
            Constructor<?> constructor = Class.forName("com.moodanalyser.MoodAnalyser").getConstructor();
            MoodAnalyser obj=(MoodAnalyser) constructor.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //For Parameterized Constructor
    public static MoodAnalyser createMoodAnalyser(String mood) {
        try {
            Constructor<?> constructor=Class.forName("com.moodanalyser.MoodAnalyser").getConstructor(String.class);
            MoodAnalyser obj=(MoodAnalyser) constructor.newInstance(mood);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className, Class constructor) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(constructor);
        } catch (ClassNotFoundException e ) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        }
    }

    public static String invokeMethod(MoodAnalyser obj, String methodName) {
        try {
            return (String) obj.getClass().getDeclaredMethod(methodName).invoke(obj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
