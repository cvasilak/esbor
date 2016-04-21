/*===============================================================================
Copyright (c) 2016 PTC Inc. All Rights Reserved.

Copyright (c) 2012-2015 Qualcomm Connected Experiences, Inc. All Rights Reserved.

Vuforia is a trademark of PTC Inc., registered in the United States and other 
countries.
===============================================================================*/


package com.vuforia.esbor;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vuforia.esbor.imagetargets.ImageTargets;
import com.vuforia.esbor.videoplayback.VideoPlayback;
import com.vuforia.esbor.virtualtour.VirtualTourTargets;

public class ActivityLauncher extends ListActivity
{
    
    private String mActivities[] = { "Προβολή 3D Μοντέλου", "Εικονική Περιήγηση",
            "Αναπαραγωγή Video"};
    
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            R.layout.activities_list_text_view, mActivities);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activities_list);
        setListAdapter(adapter);
    }
    
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {

        Intent intent = null;

        switch (position)
        {
            case 0:
                intent = new Intent(this, ImageTargets.class);
                break;
            case 1:
                intent = new Intent(this, VirtualTourTargets.class);
                break;
            case 2:
                intent = new Intent(this, VideoPlayback.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
