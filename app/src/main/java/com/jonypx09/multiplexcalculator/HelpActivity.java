package com.jonypx09.multiplexcalculator;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HelpActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private Boolean switchPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        switchPref = sharedPref.getBoolean(SettingsActivity.DARK_MODE_SWITCH, false);
        if (switchPref){
            setTheme(R.style.SettingsFragmentStyleDark);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00463E")));
            getWindow().setStatusBarColor(Color.parseColor("#FF003C35"));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00463E"));
            ((Activity)this).setTaskDescription(taskDescription);

        }else{
            setTheme(R.style.SettingsFragmentStyle);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF00A192")));
            getWindow().setStatusBarColor(Color.parseColor("#FF006E60"));
            ActivityManager.TaskDescription taskDescription = new ActivityManager.TaskDescription(null, null, Color.parseColor("#FF00A192"));
            ((Activity)this).setTaskDescription(taskDescription);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
