package course.labs.changeratecurrentcy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CountryListItemAdapter extends ArrayAdapter<Country> {
  Context context;
  List<Country> item;

  public CountryListItemAdapter(@NonNull Context context, int layoutTobeInflated, List<Country> items) {
    super(context, R.layout.list_item_country, items);
    this.context = context;
    this.item = items;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(context);
    View row = inflater.inflate(R.layout.list_item_country, null);
    TextView name = row.findViewById(R.id.country_name);
    TextView population = row.findViewById(R.id.population);
    ImageView flag = row.findViewById(R.id.country_flag);
    TextView area = row.findViewById(R.id.area);

    Log.d("Tiktzuki", "CountryListItemAdapter: "+item.get(position).getFlagurl());
    name.setText(item.get(position).getCountryName());
    population.setText(item.get(position).getPopulation()+"");

    int SDK_INT = android.os.Build.VERSION.SDK_INT;
    if (SDK_INT > 8)
    {
      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
          .permitAll().build();
      StrictMode.setThreadPolicy(policy);
      try {
        URL url = new URL(item.get(position).getFlagurl());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoInput(true);
        conn.connect();
        BitmapFactory.Options options = new BitmapFactory.Options();

        Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream(), null, options);
        flag.setImageBitmap(bitmap);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    area.setText(item.get(position).getArea()+"");
    return row;
  }
}
