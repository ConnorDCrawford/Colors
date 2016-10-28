package edu.temple.colors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by connorcrawford on 9/27/16.
 */

public class ColorArrayAdapter extends ArrayAdapter<ListColor> {

    ListColor[] colors;

    public ColorArrayAdapter(Context context, ListColor[] listColorArray) {
        super(context, 0, listColorArray);
        colors = listColorArray;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get color for position
        ListColor color = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
        }
        // Lookup view for data population
        TextView textView = (TextView) convertView;
        // Populate the data into the template view using the data object
        textView.setText(color.getName(getContext().getResources()));
        // Return the completed view to render on screen
        return convertView;
    }
}
