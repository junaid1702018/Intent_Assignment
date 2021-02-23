package com.example.Implicits;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView Web_View;
    private ProgressBar Progress_Bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Web_View = findViewById(R.id.mywebview);
        Progress_Bar = findViewById(R.id.progressBar);
         Web_View.loadUrl("https://www.fiverr.com/users/junaid51214/seller_dashboard");

        Web_View.setWebViewClient(new WebViewClient(){
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Progress_Bar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Progress_Bar.setVisibility(View.GONE);
            }
        });

        Web_View.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Progress_Bar.setProgress(newProgress);
            }
        });

        Intent intent1 = getIntent();
        if (intent1!=null){
            String URL;
            URL = intent1.getData().toString();
            Web_View.loadUrl(URL);
        }

    }


    @Override
    public void onBackPressed() {
        if (Web_View.canGoBack())
        {
            Web_View.goBack();
        }
        else
        {
            super.onBackPressed();
        }

    }
}