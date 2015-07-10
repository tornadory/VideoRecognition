package ru.mike.videorecognition;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ((EditText)view.findViewById(R.id.rootPath)).
                setText(((GlobalData) getActivity().getApplication().getApplicationContext())
                        .getRootPath());
        ((EditText)view.findViewById(R.id.dbPath)).
                setText(((GlobalData)getActivity().getApplication().getApplicationContext())
                        .getDBPath());
        ((EditText)view.findViewById(R.id.filesPath)).
                setText(((GlobalData)getActivity().getApplication().getApplicationContext())
                        .getFilesPath());
        return view;
    }

}
