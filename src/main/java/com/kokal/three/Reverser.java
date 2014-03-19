package com.kokal.three;

public class Reverser {

    public String reverse(String s){
        if (null == s) return null;

        return new StringBuilder(s).reverse().toString();
    }
}
