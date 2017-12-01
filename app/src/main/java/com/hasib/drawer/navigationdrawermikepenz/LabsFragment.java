package com.hasib.drawer.navigationdrawermikepenz;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class LabsFragment extends Fragment {

    public LabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(container !=  null)
        {
            container.removeAllViews();
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_labs, container, false);

        //Using As Constructor

        String htmlText = " %s ";
        String labText = "CSC LAB 1, 2 and 3 are general purpose computer labs. They are accessed by upward staircases beside lifts " +
                "at absolute west of the Department. As a fresher, this likely where your class will happen.";
        WebView webView = (WebView) view.findViewById(R.id.webview1);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        labText = "GPL is also a computer lab, situated just beside CSC Lab 3. This is open from 9 AM to 6 PM every working day. " +
                "Yes. Printing service is available there[No Personal paper needed]. You can both hangout or study there. ";
        webView = (WebView) view.findViewById(R.id.webview2);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        labText = "CITS looks over the all IT related service and infrastructure. Your IUB email [id@iub.edu.bd] is also managed" +
                " by them. Tips: IUB email comes with free Microsoft Office 365 subscription and many More! CITS also manages a computer " +
                "lab" +
                " and print is also available there if you have papers to print";
        webView = (WebView) view.findViewById(R.id.webview3);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        labText = "CEN lab is the main hardware lab for CSE students. It is in Basement 2, so reaching there is a hassle." +
                " Microprocessor, Prototyping, Electronics courses are taught here.";
        webView = (WebView) view.findViewById(R.id.webview4);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);





        return view;
    }

}
