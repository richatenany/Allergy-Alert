package edu.purdue.rtenany.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main3Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView ScannerView;
    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);
        ScannerView.setAutoFocus(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ScannerView.setResultHandler(this);
        ScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Log.v(TAG, result.getText());
        Log.v(TAG, result.getBarcodeFormat().toString());

        ScannerView.resumeCameraPreview(this);
    }
}
