package course.labs.testbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    String url = getIntent().getDataString();
    if(url == null)
      url = "No data provided";
    TextView textView = findViewById(R.id.txtLink);
    textView.setText(url);
  }
}