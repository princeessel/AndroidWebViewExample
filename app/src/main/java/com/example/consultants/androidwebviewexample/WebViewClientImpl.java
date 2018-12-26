package com.example.consultants.androidwebviewexample;

import android.annotation.TargetApi;
import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class WebViewClientImpl extends WebViewClient {
    private Activity activity = null;
    private ArrayList url;

    public WebViewClientImpl(Activity activity) {
        this.activity = activity;
    }
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        final Uri uri=Uri.parse(url);

        return handleUri(uri);

    }

    private boolean handleUri(final Uri uri) {
        Log.d(TAG, "handleUri: " +uri);
        final String host=uri.getHost();
        final String scheme=uri.getScheme();

        if(url.indexOf("cnn.com") > -1) {
            return false;
        }
        else {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            activity.startActivity(intent);
            return true;
        }
    }
}
