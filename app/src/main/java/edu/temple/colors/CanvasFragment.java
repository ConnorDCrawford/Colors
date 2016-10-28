package edu.temple.colors;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CanvasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CanvasFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_COLOR_ID = "arg_color_id";

    private ListColor listColor;

    public CanvasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param colorID The value of the color to be displayed.
     * @return A new instance of fragment CanvasFragment.
     */
    public static CanvasFragment newInstance(int colorID) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR_ID, colorID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            listColor = ListColor.getListColorForColorID(getArguments().getInt(ARG_COLOR_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_canvas, container, false);
    }

    public ListColor getListColor() {
        return listColor;
    }
}
