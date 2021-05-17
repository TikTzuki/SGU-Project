package course.labs.intentlab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  static public final int CODE_HELLO = 1;
  private EditText edtU;
  private EditText edtP;
  private Button btnLogin;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    edtU = findViewById(R.id.edtUserName);
    edtP = findViewById(R.id.edtPassword);
    btnLogin = findViewById(R.id.btnLogin);
    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(checkPassword(edtU.getText().toString(), edtP.getText().toString())){
          Intent intHello = new Intent(MainActivity.this, HelloActivity.class);
          startActivityForResult(intHello, CODE_HELLO);
        } else {
          Uri page = Uri.parse("http://vnexpress.net");
          Intent intWeb = new Intent(Intent.ACTION_VIEW, page);
          Intent chooser = Intent.createChooser(intWeb, "Chọn app để gọi");
          if(intWeb.resolveActivity(getPackageManager())!=null){
            startActivity(chooser);
          }
          startActivity(intWeb);
        }
      }
    });
  }
  public boolean checkPassword(String user, String pwd){
    return false;
  }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == CODE_HELLO){
      if(resultCode == RESULT_OK){
        String s = data.getStringExtra("txt");
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
      }
    }
  }
}