package edu.temple.colors;

/**
 * Created by connorcrawford on 9/27/16.
 */

import android.content.res.Resources;
import android.graphics.Color;

public enum ListColor {
    RED(Color.RED),
    ORANGE(Color.rgb(255, 165, 0)),
    YELLOW(Color.YELLOW),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    INDIGO(Color.rgb(75, 0, 130)),
    VIOLET(Color.rgb(238, 130, 238));


    int color;

    ListColor(int color) {
        this.color = color;
    }

    String getName(Resources resources) {
        switch (this) {
            case RED:
                return resources.getString(R.string.red);
            case ORANGE:
                return resources.getString(R.string.orange);
            case YELLOW:
                return resources.getString(R.string.yellow);
            case GREEN:
                return resources.getString(R.string.green);
            case BLUE:
                return resources.getString(R.string.blue);
            case INDIGO:
                return resources.getString(R.string.indigo);
            case VIOLET:
                return resources.getString(R.string.violet);
        }
        return null;
    }

    int getColor() {
        return color;
    }

    static ListColor getListColorForColorID(int colorID) {
        if (colorID == RED.color)
            return RED;
        else if (colorID == ORANGE.color)
            return ORANGE;
        else if (colorID == YELLOW.color)
            return YELLOW;
        else if (colorID == GREEN.color)
            return GREEN;
        else if (colorID == BLUE.color)
            return BLUE;
        else if (colorID == INDIGO.color)
            return INDIGO;
        else if (colorID == VIOLET.color)
            return VIOLET;
        else
            return null;
    }
}

