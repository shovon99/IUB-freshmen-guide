package com.hasib.drawer.navigationdrawermikepenz;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.context.IconicsContextWrapper;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onCreateDrawer();

    }

    public void onCreateDrawer()
    {
        toolbar = findViewById(R.id.toolbarMain);

        new DrawerBuilder().withActivity(this).build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_home).withIdentifier(1)
                .withName(R.string.drawer_item_home);
        //SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(2)
                .withName(R.string.drawer_item_settings);

        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2
                        //,
                        //new SecondaryDrawerItem().withName("For Settings")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position)
                        {
                            case 0: {
                                Snackbar.make(view, "Home Drawer Item Clicked", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                Log.i("Error", "Case 1 Reached");
                                selectFrag(1);
                                //startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                break;
                            }
                            case 1: {
                                Log.i("Error", "DividerDrawerItem Can't be Clicked");
                            }
                            case 2: {
                                Snackbar.make(view, "Settings Drawer Item Clicked", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                Log.i("Error", "Case 2 Reached");
                                selectFrag(2);
                                //startActivity(new Intent(getApplicationContext(), anotherActivity.class));
                                //setContentView();
                                break;
                            }
                        }

                        return true;
                    }
                })
                .build();
    }
    public void selectFrag(int i)
    {
        Fragment fr;

        if(i == 1)
        {
            fr = new fragmentone();

        }
        else fr = new Fragmenttwo();

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fr);
        transaction.commit();

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }

}
