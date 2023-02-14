package cnam.smb116.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
}