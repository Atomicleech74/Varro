package com.example.varro.ui.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.varro.R;
import com.google.android.gms.common.SignInButton;

public class SplashFragment extends Fragment {

    private SplashViewModel splashViewModel;
    private SignInButton signInButton;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        splashViewModel =
                new ViewModelProvider(this).get(SplashViewModel.class);
        View root = inflater.inflate(R.layout.fragment_splash, container, false);
        final TextView textView = root.findViewById(R.id.textView);
        splashViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        signInButton = root.findViewById(R.id.sign_in_button);
        setGooglePlusButtonText(signInButton, "Sign in with Google");
        return root;
    }

    protected void setGooglePlusButtonText(SignInButton signInButton, String buttonText) {
        // Find the TextView that is inside of the SignInButton and set its text
        for (int i = 0; i < signInButton.getChildCount(); i++) {
            View v = signInButton.getChildAt(i);

            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                tv.setText(buttonText);
                tv.setWidth(tv.getWidth()*2);
                return;
            }
        }
    }
}