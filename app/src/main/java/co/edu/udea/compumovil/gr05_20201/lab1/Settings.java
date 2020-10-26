package co.edu.udea.compumovil.gr05_20201.lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class Settings extends PreferenceFragmentCompat {

    SharedPreferences preferences;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        preferences = this.getActivity().getSharedPreferences("Lab1Activities", Context.MODE_PRIVATE);
        setPreferencesFromResource(R.xml.activity_config, rootKey);
        final Preference button = findPreference(getString(R.string.preference_button));
        button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("activeUser","");
                editor.commit();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
            }
        });
    }
}
