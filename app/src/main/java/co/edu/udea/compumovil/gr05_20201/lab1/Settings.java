package co.edu.udea.compumovil.gr05_20201.lab1;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import co.edu.udea.compumovil.gr05_20201.lab1.R;

public class Settings extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.activity_config, rootKey);
    }

}
