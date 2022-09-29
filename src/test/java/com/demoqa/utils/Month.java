package com.demoqa.utils;

public enum Month {
    January, February, March, April, May, June, July, August, September, October, November, December;
    public static Month getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
