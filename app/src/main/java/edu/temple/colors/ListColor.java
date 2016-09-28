package edu.temple.colors;

/**
 * Created by connorcrawford on 9/27/16.
 */

import android.graphics.Color;

public enum ListColor {
    RED("Red", Color.RED),
    ORANGE("Orange", Color.rgb(255, 165, 0)),
    YELLOW("Yellow", Color.YELLOW),
    GREEN("Green", Color.GREEN),
    BLUE("Blue", Color.BLUE),
    INDIGO("Indigo", Color.rgb(75, 0, 130)),
    VIOLET("Violet", Color.rgb(238, 130, 238));


    String name;
    int color;

    ListColor(String name, int color) {
        this.name = name;
        this.color = color;
    }

    String getName() {
        return name;
    }

    int getColor() {
        return color;
    }
}

