package com.samsung.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SendFragment extends Fragment {
    String message = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.send_fragment, container, false);

        view.findViewById(R.id.message_send_button).setOnClickListener(v -> {
            EditText text = view.findViewById(R.id.chat_message);
            String messageText = text.getText().toString();

            if (messageText.isEmpty()) {
                return;
            }

            message = messageText;
            text.setText("");
        });

        return view;
    }

    public String getMessage() {
        return message;
    }
}
