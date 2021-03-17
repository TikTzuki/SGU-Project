package course.labs.changeratecurrentcy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import course.labs.changeratecurrentcy.repository.CountryApi;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListCountryActivity extends AppCompatActivity {
  CountryApi countryApi;

  Button btnLoad;

  ListView countryListView;
  List<Country> items;
  CountryListItemAdapter adapter;

  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_country);
  countryListView = findViewById(R.id.list_view_country);
    btnLoad = findViewById(R.id.loadCountry);
    btnLoad.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        loadCountry();
      }
    });

    createCountryApi();
//    adapter = new CountryListItemAdapter(this, R.layout.list_item_country, items);
//    countryListView = findViewById(R.id.list_view_country);
//    countryListView.setAdapter(adapter);
  }


  private void createCountryApi(){
    Gson gson = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//        .registerTypeAdapter(Country.class, new CountryDeserializer())
        .create();
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addInterceptor(new Interceptor() {
          @Override
          public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder();
            Request newRequest = builder.build();
            return chain.proceed(newRequest);
          }
        }).build();

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(CountryApi.ENDPOINT)
//        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    countryApi = retrofit.create(CountryApi.class);
  }

  private void loadCountry(){
    compositeDisposable.add(countryApi.getCountry("USA")
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribeWith(getCountryObserver()));
  }

  DisposableSingleObserver<CountryInfo> getCountryObserver(){
    return new DisposableSingleObserver<CountryInfo>() {
      @Override
      public void onSuccess(CountryInfo value) {
        if(!value.equals(null)){
          Log.d("Tiktzuki", "onSuccess: "+value);
          List<Country> items = value.geonames;
          adapter = new CountryListItemAdapter(
              ListCountryActivity.this,
              R.layout.list_item_country,
              items);
          countryListView.setAdapter(adapter);
          countryListView.setEnabled(true);
        }
      }

      @Override
      public void onError(Throwable e) {
        e.printStackTrace();
        Toast.makeText(ListCountryActivity.this, "Can not load country", Toast.LENGTH_SHORT).show();
      }
    };
  }

}
