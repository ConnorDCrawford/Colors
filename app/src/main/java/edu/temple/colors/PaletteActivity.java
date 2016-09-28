package edu.temple.colors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class PaletteActivity extends Activity {

    private ListColor[] listColors = ListColor.values();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(new ColorArrayAdapter(this, listColors));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                intent.putExtra(CanvasActivity.ARG_COLOR_ID, listColors[position]);
                startActivity(intent);
            }
        });

    }
}
