package com.example.varro.ui.call;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.varro.R;

public class CallFragment extends Fragment {

    private CallViewModel callViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        callViewModel =
                new ViewModelProvider(this).get(CallViewModel.class);
        View root = inflater.inflate(R.layout.fragment_call, container, false);

        WebView webView = (WebView)root.findViewById(R.id.web_view);
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onPermissionRequest(final PermissionRequest request) {
                Log.println(Log.INFO, null, "REQUESTING PERMISSIONS==============================================");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    request.grant(request.getResources());
                }
            }

        });
        webView.setBackgroundColor(Color.rgb(230,230,230));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        Log.println(Log.WARN, null, "LOADING FILE+++++++++++++++++++");
        webView.loadUrl("file:///android_asset/sample.html");

        return root;
    }
}