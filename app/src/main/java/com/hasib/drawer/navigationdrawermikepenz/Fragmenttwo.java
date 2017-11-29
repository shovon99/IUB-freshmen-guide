package com.hasib.drawer.navigationdrawermikepenz;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;


public class Fragmenttwo extends Fragment{
    //RelativeLayout m;
    public Fragmenttwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(container !=  null)
        {
            container.removeAllViews();
        }

        View view = inflater.inflate(R.layout.fragment_fragmenttwo, container, false);

        Button m = (Button) view.findViewById(R.id.frag2Button);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Fragment two Button Worked !!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Do Something here for loading something from Constructor


        return view;
    }



}
