package app.fmu.tcc.yourphysio.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.fmu.tcc.yourphysio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciciosFragment extends Fragment {


    public ExerciciosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercicios, container, false);
    }

}
