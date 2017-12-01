package com.hasib.drawer.navigationdrawermikepenz;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class fragmentone extends Fragment {

    ArrayList<Courses> courses = new ArrayList<>();
    double cgpa;
    double gpa;
    int cr;

    public fragmentone() {
        // Required empty public constructor
    }
    public double gpaTranslator(String gpa)
    {
        if(gpa.equals("A")) return 4.00;
        if(gpa.equals("A-")) return 3.70;
        if(gpa.equals("B+")) return 3.3;
        if(gpa.equals("B")) return 3;
        if(gpa.equals("B-")) return 2.7;
        if(gpa.equals("C+")) return 2.3;
        if(gpa.equals("C")) return 2;
        if(gpa.equals("C-")) return 1.7;
        if(gpa.equals("D+")) return 1.3;
        if(gpa.equals("D")) return 1;
        if(gpa.equals("P")) return 0;
        else return 0;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(container !=  null)
        {
            container.removeAllViews();
        }


        View view = inflater.inflate(R.layout.fragmentone, container, false);

        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.Grades, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        spinner.setSelection(0);



//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
//
//                //String items = spinner.getSelectedItem().toString();
//                //Log.i("Selected item : ", items);
//                //spinner.setSelection(arg2);
//                //adapter.notifyDataSetChanged();
//                //currentgpa = gpaTranslator(spinner.getSelectedItem().toString());
//                //Toast.makeText(getActivity().getApplicationContext(), "Item Selected! ", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                //spinner.setSelection(0);
//
//            }
//
//        });

        final Spinner spinner2 = (Spinner) view.findViewById(R.id.sp2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.Credits, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
        spinner2.setSelection(0);


//        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
//
//                //String items = spinner.getSelectedItem().toString();
//                //Log.i("Selected item : ", items);
//                //spinner.setSelection(arg2);
//                //adapter.notifyDataSetChanged();
//                //currentcredit = Integer.parseInt(spinner2.getSelectedItem().toString());
//                //Toast.makeText(getActivity().getApplicationContext(), "Item Selected from Credit! ", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                //spinner.setSelection(0);
//
//            }
//
//        });
        final EditText editText = (EditText) view.findViewById(R.id.editText);
        final TextView textView = (TextView) view.findViewById(R.id.cgpaShow);

        Button b = (Button) view.findViewById(R.id.addCourse);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity().getApplicationContext(), "Working", Toast.LENGTH_SHORT).show();
                if(!editText.getText().equals(""))
                {
                    courses.add(new Courses(editText.getText().toString(), gpaTranslator(spinner.getSelectedItem().toString()), Integer.parseInt(spinner2.getSelectedItem().toString())));
                }

                for(Courses C : courses)
                {
                    double tGPA = C.gpa * C.credit;
                    gpa += tGPA;
                    cr += C.credit;
                }
                cgpa = gpa / cr;

                textView.setText("Your CGPA: " + cgpa);



            }
        });

        return view;
    }

}
