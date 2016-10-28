package edu.temple.colors;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

public class PaletteActivity extends Activity implements PaletteFragment.OnListFragmentInteractionListener {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle(getTitle());

        //  Load palette fragment by default
        Fragment paletteFragment = new PaletteFragment();
        loadFragment(R.id.fragment_palette, paletteFragment, false);

        ListView listView = (ListView) findViewById(R.id.palette_list);
        assert listView != null;
//        setupListView(listView);

        if (findViewById(R.id.fragment_canvas) != null) {
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
            loadFragment(R.id.fragment_canvas, new CanvasFragment(), false);
        }

    }

    private void setupListView(ListView listView) {
        listView.setAdapter(new ColorArrayAdapter(this, ListColor.values()));
    }

    //  Load fragment in a specified frame
    private void loadFragment(int paneId, Fragment fragment, boolean placeOnBackstack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .replace(paneId, fragment);
        if (placeOnBackstack)
            ft.addToBackStack(null);
        ft.commit();

        //  Ensure fragment is attached before attempting to call its public methods
        fm.executePendingTransactions();
    }

    @Override
    public void onSelectColor(ListColor color) {
        CanvasFragment canvasFragment = CanvasFragment.newInstance(color.color);

        loadFragment(mTwoPane ? R.id.fragment_canvas : R.id.fragment_palette, canvasFragment, !mTwoPane);
        canvasFragment.getView().setBackgroundColor(canvasFragment.getListColor().color);
    }
}
