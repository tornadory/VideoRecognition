package ru.mike.videorecognition;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentFragment = new CameraFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, currentFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.MainMenu_settings :
                replaceFragment(new SettingsFragment());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void replaceFragment(final Fragment newFragment) {
        if ( currentFragment != null && currentFragment != newFragment ) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(currentFragment.getId(), newFragment).commit();
            currentFragment = newFragment;
        }
    }

    public void itemOnClick(final View view) {
        switch (view.getId()) {
            case R.id.settingsReturn :
                replaceFragment(new CameraFragment());
                break;
            case R.id.settingsSaveAndReturn :
                saveSettings();
                replaceFragment(new CameraFragment());
                break;
            default:
                Toast.makeText(getApplicationContext(),
                        getText(R.string.unknownItemOnClick),
                        Toast.LENGTH_SHORT).show();
        }
    }

    private void saveSettings() {
        //TODO save application settings
    }

}
