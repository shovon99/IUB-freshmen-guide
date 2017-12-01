package com.hasib.drawer.navigationdrawermikepenz;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toolbar;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar  toolbar;
    //boolean frStatus = false;
    //Drawer result;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateDrawer();
        //setContentView(R.layout.activity_main);

        //onCreateDrawer();

    }


    public void onCreateDrawer()
    {
        toolbar = findViewById(R.id.toolbarMain);

        new DrawerBuilder().withActivity(this).build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIcon(FontAwesome.Icon.faw_graduation_cap).withIdentifier(1)
                .withName("CGPA Calculator");
        //SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);
        PrimaryDrawerItem item1_5 = new PrimaryDrawerItem().withIcon(FontAwesome.Icon.faw_qrcode).withIdentifier(4)
                .withName("Lift Confusions !!");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIcon(MaterialDesignIconic.Icon.gmi_map).withIdentifier(2)
                .withName("Department Map");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIcon(MaterialDesignIconic.Icon.gmi_directions_run).withIdentifier(3)
                .withName("Faculty Rooms");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIcon(FontAwesome.Icon.faw_address_book).withIdentifier(4)
                .withName("Faculty Contact No.");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIcon(FontAwesome.Icon.faw_microchip).withIdentifier(4)
                .withName("Labs, GPL and CITS");
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIcon(FontAwesome.Icon.faw_cube).withIdentifier(4)
                .withName("CRIB,CCSE,NetworkLAB,FabLAB");

        //FontAwesome.Icon.faw_cube

        //create the drawer and remember the `Drawer` result object
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item1_5,
                        item2,
                        item3,
                        item4,
                        item5,
                        item6
                        //,
                        //new SecondaryDrawerItem().withName("For Settings")
                )
                .withSelectedItem(-1).build();
        result.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                switch (position)
                        {
                            case 0: {
//                                Snackbar.make(view, "Home Drawer Item Clicked", Snackbar.LENGTH_LONG)
//                                        .setAction("Action", null).show();
                                Log.i("Error", "Case 1 Reached");

                                Fragment fr1 = new fragmentone();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, fr1).commit();
                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;
                            }
                            case 1: {
                                Log.i("Error", "DividerDrawerItem Can't be Clicked");
                            }
                            case 2: {
//                                Snackbar.make(view, "Settings Drawer Item Clicked", Snackbar.LENGTH_LONG)
//                                        .setAction("Action", null).show();
                                Log.i("Error", "Case 2 Reached");
                                Fragment fr2 = new Fragmenttwo();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, fr2).commit();

                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;
                            }
                            case 3:
                            {
                                Fragment frmap = new DepartmentMap();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, frmap).commit();

                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;

                            }
                            case 4:
                            {
                                Fragment frroom = new FacultyRooms();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, frroom).commit();

                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;

                            }
                            case 5:
                            {
                                Fragment frcon = new FacultyContact();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, frcon).commit();

                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;

                            }
                            case 6:
                            {
                                Fragment fr3 = new LabsFragment();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, fr3).commit();

                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;

                            }
                            case 7:
                            {
                                Fragment fr4 = new cribFragment();
                                FragmentManager manager = getFragmentManager();
                                manager.beginTransaction().replace(R.id.fragment, fr4).commit();

                                new CountDownTimer(200,200){
                                    @Override
                                    public void onTick(long millisUntilFinished){}

                                    @Override
                                    public void onFinish(){
                                        result.closeDrawer();
                                    }
                                }.start();
                                break;

                            }

                        }

                return false;
            }
        });

    }




    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }

}
