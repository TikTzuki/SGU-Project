package course.labs.intentlab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HelloActivity extends AppCompatActivity {
  Button btn;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hello);
    btn = findViewById(R.id.btnHello);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        EditText edt = findViewById(R.id.edtHello);
        Intent ret = new Intent();
        ret.putExtra("txt", edt.getText().toString());
        ret.setType("text/plan");
        setResult(RESULT_OK, ret);
        finishActivity(MainActivity.CODE_HELLO);
        finish();
      }
    });
  }
}
