package com.hasib.drawer.navigationdrawermikepenz;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
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

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;
import java.util.HashMap;

public class fragmentone extends Fragment {


    double cgpa=0;
    double gpa=0;
    int cr=0;
    //int selectedIn = 0;
    View view;

    public fragmentone() {
        // Required empty public constructor
    }
    public void CourseListShower()
    {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(getActivity());
        builderSingle.setIcon(new IconicsDrawable(getActivity().getApplicationContext())
                .icon(FontAwesome.Icon.faw_briefcase)
                .color(Color.RED));
        builderSingle.setTitle("Courses which you have already Added:");


        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_singlechoice);
        for(Courses c: MainActivity.courses)
        {
            arrayAdapter.add(c.courseID);
        }

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {
                final String strName = arrayAdapter.getItem(which);
                AlertDialog.Builder builderInner = new AlertDialog.Builder(getActivity());
                for(Courses c: MainActivity.courses)
                {
                    if (c.courseID.equals(strName))
                    {
                        builderInner.setMessage(c.courseID + " Cr: " + c.credit + " Grade:" + c.gpa);

                    }
                }

                builderInner.setTitle("Details");
                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        dialog.dismiss();
                    }
                });
                builderInner.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try{
                            //MainActivity.mDatabase.execSQL("DELETE FROM courseList WHERE courseID = "+ strName +";");
                            if(MainActivity.mDatabase.isOpen()) Log.i(" Database Access", "Open");
                            else Log.i(" Database Access", "Close");

                            if(MainActivity.mDatabase.isReadOnly()) Log.i(" Database Access", "Read Only");
                            else Log.i(" Database Access", "Write Enabled");

                            MainActivity.mDatabase.delete("courseList", "courseID = '" + strName + "'"  , null);
                            Log.i(" Postion of Course", getCourseListPosition(strName)+"");
                            MainActivity.courses.remove(getCourseListPosition(strName));
                            Toast.makeText(getActivity().getApplicationContext(), "Course Have been Deleted.", Toast.LENGTH_SHORT).show();

                            arrayAdapter.notifyDataSetChanged();

                        }catch (Exception e)
                        {
                            Log.i("Course Delete Error: ", e.toString());
                            Toast.makeText(getActivity().getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                        }

                        dialog.dismiss();
                    }
                });
                builderInner.show();
            }
        });
        builderSingle.show();
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


        view = inflater.inflate(R.layout.fragmentone, container, false);

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


        final EditText editText = view.findViewById(R.id.editText);


        Button viewCourse = view.findViewById(R.id.viewCourses);

        viewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                CourseListShower();
            }
        });

        Button resCourse = view.findViewById(R.id.ResetCourse);

        resCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                //MainActivity.courses.rem
                try{
                    MainActivity.courses.clear();
                    MainActivity.mDatabase.execSQL("DELETE FROM courseList");
                    Toast.makeText(getActivity().getApplicationContext(), "All Courses have been Deleted ! ", Toast.LENGTH_SHORT).show();


                }catch (Exception e)
                {
                    Log.i(" Database Error",e.toString());
                    Toast.makeText(getActivity().getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });

        Button showCgpa = view.findViewById(R.id.cgpaShow);
        showCgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cg = cgpashow();
                Toast.makeText(getActivity().getApplicationContext(), "CGPA: " + String.format("%.4f", cg)  , Toast.LENGTH_SHORT).show();
            }
        });

        Button b = (Button) view.findViewById(R.id.addCourse);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                //Toast.makeText(getActivity().getApplicationContext(), "Working", Toast.LENGTH_SHORT).show();
                if(!editText.getText().toString().equals(""))
                {
                    try{
                        MainActivity.courses.add(new Courses(editText.getText().toString(), gpaTranslator(spinner.getSelectedItem().toString()), Integer.parseInt(spinner2.getSelectedItem().toString())));
                        MainActivity.mDatabase.execSQL("INSERT INTO courseList (courseID , credits , grade ) VALUES('"+ editText.getText().toString()
                                +"', '"+ Integer.parseInt(spinner2.getSelectedItem().toString())
                                +"', '"+ spinner.getSelectedItem().toString() +"')");
                        Toast.makeText(getActivity().getApplicationContext(), "Course Added", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                        spinner.setSelection(0);
                        spinner2.setSelection(0);

                    }catch (Exception e)
                    {
                        Log.i("ADD COURSE ERROR", e.toString());
                        Toast.makeText(getActivity().getApplicationContext(), "Something Wrong! Please Restart!", Toast.LENGTH_SHORT).show();

                    }


                }
                else {
                    Toast.makeText(getActivity().getApplicationContext(), "CourseID is empty!", Toast.LENGTH_SHORT).show();
                }

                //cgpashow(view);



            }
        });

        return view;
    }
    public double cgpashow()
    {
        cgpa = 0;
        gpa=0;
        cr=0;

        //TextView textView = view.findViewById(R.id.cgpaShow);
        for(Courses C : MainActivity.courses)
        {
            double tGPA = C.gpa * C.credit;
            gpa += tGPA;
            cr += C.credit;
        }
        cgpa = gpa / cr;

        //textView.setText("Your CGPA: " + String.format("%.4f", cgpa));
        return cgpa;
    }

    public int getCourseListPosition(String Name)
    {
        int i=0;
        for (Courses c: MainActivity.courses)
        {

            if(c.courseID.equals(Name)) return i;
            i++;
        }
        return 0;
    }

}
