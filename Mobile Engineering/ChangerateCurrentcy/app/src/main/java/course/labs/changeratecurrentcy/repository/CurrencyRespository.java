package course.labs.changeratecurrentcy.repository;

import cn.javaer.retrofit2.converter.jaxb.JaxbConverterFactory;
import course.labs.changeratecurrentcy.CurrencyService;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class CurrencyRespository {
  private CurrencyService service;
  public static final String BASE_URL = "https://api.example.com";
  Retrofit retrofit;

  public CurrencyRespository() {
    retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//        .client(new OkHttpClient())
//        .addConverterFactory(
//            JaxbConverterFactory.create()
//        ).addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build();
    this.service = retrofit.create(CurrencyService.class);
  }

//  public Call<String> getStuff(String user){
//    return service.getCurrency(user);
//  }
}
