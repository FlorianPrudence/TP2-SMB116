package cnam.smb116.tp2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
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

    public void doView(View view) {
        final EditText url_input = findViewById(R.id.websiteURL);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url_input.getText().toString())) ;
        startActivity(i);
    }


    public void doLogin(View view){
        Intent intent = new Intent();
        // Solution pour démarrer le composant de login avec Intent explicite
        // intent.setComponent(new ComponentName("cnam.smb116.tp2_login","cnam.smb116.tp2_login.MainActivity"));

        // Solution pour démarrer le composant de login avec Intent implicite
        intent.setAction("TP2_SMB116_LOGIN");

        loginResultLauncher.launch(intent);
    }

    public void manageOkResult(Intent intentResult) {
        String username = intentResult.getStringExtra("username");
        String password = intentResult.getStringExtra("password");

        Context context = getApplicationContext();
        CharSequence text = "Username : " + username + ", Password : " + password;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void manageCanceledResult() {
        Context context = getApplicationContext();
        CharSequence text = "Login annulé par l'utilisateur";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    ActivityResultLauncher<Intent> loginResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    manageOkResult(data);
                }
                if (result.getResultCode() == Activity.RESULT_CANCELED) {
                    manageCanceledResult();
                }
            });
}