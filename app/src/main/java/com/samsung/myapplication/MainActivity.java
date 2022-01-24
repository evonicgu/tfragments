package com.samsung.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ReceiveFragment receiveFragment = new ReceiveFragment();
    SendFragment sendFragment = new SendFragment();
    boolean state = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.chat_placeholder, receiveFragment);

        transaction.commit();

        findViewById(R.id.receive_button).setOnClickListener(v -> {
            if (state) {
                state = false;

                receiveFragment.setMessage(sendFragment.getMessage());

                FragmentTransaction sendTransaction = manager.beginTransaction();

                sendTransaction.replace(R.id.chat_placeholder, receiveFragment);

                sendTransaction.commit();
            }
        });

        findViewById(R.id.send_button).setOnClickListener(v -> {
            if (!state) {
                state = true;

                FragmentTransaction receiveTransaction = manager.beginTransaction();

                receiveTransaction.replace(R.id.chat_placeholder, sendFragment);

                receiveTransaction.commit();
            }
        });
    }
}