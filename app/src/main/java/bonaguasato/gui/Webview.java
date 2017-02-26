package bonaguasato.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);


        WebView WebView = (WebView)
                findViewById(R.id.WebView);
        WebView.setWebChromeClient(new WebChromeClient());
        WebView.setWebViewClient(new WebViewClient());
        WebView.getSettings().setJavaScriptEnabled(true);

        WebView.loadUrl("https://console.firebase.google.com");
    }
}
