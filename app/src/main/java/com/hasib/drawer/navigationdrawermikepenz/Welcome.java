package com.hasib.drawer.navigationdrawermikepenz;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.context.IconicsContextWrapper;


public class Welcome extends Fragment {

    public Welcome() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_welcome, container, false);

        //TextView welcome = view.findViewById(R.id.textView9);
        //Drawable dr = new IconicsDrawable(getActivity().getApplicationContext()).icon(FontAwesome.Icon.faw_briefcase).color(Color.RED);
        //welcome.setCompoundDrawablesWithIntrinsicBounds(getResources().get,0,0,0);



        return view;
    }


}
