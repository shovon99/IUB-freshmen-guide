package com.hasib.drawer.navigationdrawermikepenz;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class Fragmenttwo extends Fragment{
    //RelativeLayout m;
    TableLayout tl;
    TableRow tr;
    String LiftButtons[] = {"1", "2", "3", "4", "5", "6", "8"};
    String Levels[] = {"2", "3, 4", "Nowhere", "5, 6", "Nowhere", "7, 8", "9, 10"};
    TextView lButton;
    TextView levels;
    public Fragmenttwo() {
        // Required empty public constructor
    }

    public void addHeaders(){

        /** Create a TableRow dynamically **/
        tr = new TableRow(getActivity().getApplicationContext());
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        /** Creating a TextView to add to the row **/
        TextView textView = new TextView(getActivity().getApplicationContext());
        textView.setText("Lift Button");
        textView.setTextColor(Color.GRAY);
        textView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textView.setPadding(5, 5, 5, 0);

        tr.addView(textView);  // Adding textView to tablerow.

        /** Creating another textview **/
        TextView textView1 = new TextView(getActivity().getApplicationContext());
        textView1.setText("Go To Level");
        textView1.setTextColor(Color.GRAY);
        textView1.setPadding(5, 5, 5, 0);
        textView1.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(textView1); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        // we are adding two textviews for the divider because we have two columns
        tr = new TableRow(getActivity().getApplicationContext());
        tr.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));

        /** Creating another textview **/
        TextView textView2 = new TextView(getActivity().getApplicationContext());
        textView2.setText("-----------------");
        textView2.setTextColor(Color.GREEN);
        textView2.setPadding(5, 0, 0, 0);
        textView2.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(textView2); // Adding textView to tablerow.

        TextView textView3 = new TextView(getActivity().getApplicationContext());
        textView3.setText("-------------------------");
        textView3.setTextColor(Color.GREEN);
        textView3.setPadding(5, 0, 0, 0);
        textView3.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        tr.addView(textView3); // Adding textView to tablerow.

        // Add the TableRow to the TableLayout
        tl.addView(tr, new TableLayout.LayoutParams(
                TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
    }

    public void addData(){

        for (int i = 0; i < LiftButtons.length; i++)
        {
            /** Create a TableRow dynamically **/
            tr = new TableRow(getActivity().getApplicationContext());
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            /** Creating a TextView to add to the row **/
            lButton = new TextView(getActivity().getApplicationContext());
            lButton.setText(LiftButtons[i]);
            lButton.setTextColor(Color.RED);
            lButton.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            lButton.setPadding(5, 5, 5, 5);
            tr.addView(lButton);  // Adding textView to tablerow.

            /** Creating another textview **/
            levels = new TextView(getActivity().getApplicationContext());
            levels.setText(Levels[i]);
            levels.setTextColor(Color.GREEN);
            levels.setPadding(5, 5, 5, 5);
            levels.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            tr.addView(levels); // Adding textView to tablerow.

            // Add the TableRow to the TableLayout
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.FILL_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
        }
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


        //Do Something here for loading something from Constructor

        //tl = (TableLayout) view.findViewById(R.id.table);
        //addHeaders();
        //addData();


        return view;
    }



}
