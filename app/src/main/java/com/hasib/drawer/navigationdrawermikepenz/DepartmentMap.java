package com.hasib.drawer.navigationdrawermikepenz;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class DepartmentMap extends Fragment {



    public DepartmentMap() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(container!=null)
        {
            container.removeAllViews();
        }
        View view = inflater.inflate(R.layout.fragment_department_map, container, false);




        return view;
    }

}
