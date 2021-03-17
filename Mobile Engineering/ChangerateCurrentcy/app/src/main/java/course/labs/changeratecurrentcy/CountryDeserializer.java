package course.labs.changeratecurrentcy;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountryDeserializer implements JsonDeserializer<List<Country>> {
  @Override
  public List<Country> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    List<Country> countries = new ArrayList<>();
    Log.d("Tiktzuki", "deserialize: "+json);
//    JsonObject geonamesJsonObject = json.getAsJsonObject();
//    JsonArray geonamesArray = geonamesJsonObject.getAsJsonArray();
//    Iterator<JsonElement> itr = geonamesArray.iterator();
//    while(itr.hasNext()){
//      JsonObject obj = (JsonObject) itr.next();
//      Country country = new Country(
//         obj.get("countryName").getAsString(),
//         "http://www.geonames.org/flags/x/" + String.format("%s",obj.get("countryCode")).toLowerCase() + ".gif",
//          obj.get("population").getAsLong(),
//          obj.get("areaInSqKm").getAsDouble()
//      );
//      countries.add(country);
//    }

    return countries;
  }

  public  List<Country> fromCountry(String json){
   return new ArrayList<>();
  }
}
