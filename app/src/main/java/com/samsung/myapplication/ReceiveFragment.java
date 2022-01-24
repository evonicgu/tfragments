package com.samsung.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ReceiveFragment extends Fragment {
    String message = "";

    @Override
    public void onResume() {
        super.onResume();

        TextView text = getView().findViewById(R.id.message_box);
        text.setText(message);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.receive_fragment, container, false);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
