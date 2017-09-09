package com.example.android.domaktora;

    import android.Manifest;
    import android.view.View;
    import android.content.Intent;
    import android.app.Activity;
    import android.net.Uri;
    import android.content.ActivityNotFoundException;
    import android.content.Intent;
    import android.content.pm.PackageManager;
    import android.os.Bundle;
    import android.support.v4.app.ActivityCompat;
    import android.support.v7.app.AppCompatActivity;
    import android.text.Html;
    import android.text.method.LinkMovementMethod;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;

    import static android.R.attr.name;
    import static android.R.attr.text;
    import static android.R.id.message;

public class MainActivity extends AppCompatActivity {
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonCall);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:+48 58 301 59 01"));

                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });

    }

    public void openMap(View v) {
        button = (Button) findViewById(R.id.openMap);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?q= Straganiarska 55/56, 80-837 Gdansk, Poland"));
        startActivity(intent);


    }



}