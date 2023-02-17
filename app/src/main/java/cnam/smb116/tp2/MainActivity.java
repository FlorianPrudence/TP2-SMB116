package cnam.smb116.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doCall(View view) {
        final EditText number_input = findViewById(R.id.phoneNumber);
        Uri phoneNumber = Uri.parse("tel:" + number_input.getText().toString());
        Intent i = new Intent(Intent.ACTION_DIAL, phoneNumber);
        startActivity(i);
    }

    public void doView(View view) {
        final EditText url_input = findViewById(R.id.websiteURL);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url_input.getText().toString())) ;
        startActivity(i);
    }
}