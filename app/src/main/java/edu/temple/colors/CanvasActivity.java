package edu.temple.colors;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.app.ActionBar;
import android.view.MenuItem;

public class CanvasActivity extends Activity {

    public static final String ARG_COLOR_ID = "arg_color_id";

    private ListColor color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // Show the Up button in the action bar.
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // Get color from intent
            color = (ListColor) extras.get(ARG_COLOR_ID);

            // Set action bar title
            setTitle(color.getName());

            // Set background color
            ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.activity_canvas);
            layout.setBackgroundColor(color.color);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                this.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
