package com.probadr98.ndktest;


public class NativeClass {

    public native static String getMessageFromJNI();
    public static String  getMessage(){
        return getMessageFromJNI();
    }
}
