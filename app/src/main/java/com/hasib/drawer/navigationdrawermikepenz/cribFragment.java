package com.hasib.drawer.navigationdrawermikepenz;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class cribFragment extends Fragment {



    public cribFragment() {
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
        View view = inflater.inflate(R.layout.fragment_crib, container, false);

        String htmlText = " %s ";
        String labText = "AKA Research Lab. This houses good configuration PCs and iMacs. Access is controlled via Fingerprint." +
                "To gain access you need to be engaged in research activity and apply for access. This lab has it's own vibe.";
        WebView webView = (WebView) view.findViewById(R.id.webview1);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        labText = "CCSE has the most powerful computers in IUB. It has a mini-super computer and dozens of high config PC. It is big" +
                "gest Lab in School of Engineering and Computer Science(SECS). You can't access this lab as it is highly restricted.";
        webView = (WebView) view.findViewById(R.id.webview2);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        labText = "NetworkLAB = CSC Lab 4. The only classroom with high config PC both with Graphics card and RAM. It has network " +
                "Scaled infrastructure too for networking class. It is beside CRIB.";
        webView = (WebView) view.findViewById(R.id.webview3);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        labText = "Fabrication LAB is a joint venture of Bangladesh Government and IUB. Only IUB has this partnership among all " +
                "Private Universities. FABLAB has huge amount of machinery's and resource to build anything from scratch. It is " +
                "on the Lift Button 5.";
        webView = (WebView) view.findViewById(R.id.webview4);
        webView.loadData(String.format(htmlText, labText), "text/html", "utf-8");
        webView.setBackgroundColor(Color.TRANSPARENT);

        //Doing Constructor works here




        return view;
    }

}
