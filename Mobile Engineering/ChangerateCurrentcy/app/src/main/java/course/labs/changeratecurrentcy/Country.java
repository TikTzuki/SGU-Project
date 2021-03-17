package course.labs.changeratecurrentcy;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Country {
  String continent;
  String capital;
  String languages;
  String countryName;
  String countryCode;
  String flagurl;
  String population;
  String areaInSqKm;

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getFlagurl() {
    return "https://www.countryflags.io/"+String.format("%s", this.countryCode)  +"/flat/64.png";
//    return "http://www.geonames.org/flags/x/" + String.format("%s",this.countryCode).toLowerCase() + ".gif";
  }

  public void setFlagurl(String flagurl) {
    this.flagurl = flagurl;
  }

  public String getPopulation() {
    return population;
  }

  public void setPopulation(String population) {
    this.population = population;
  }

  public String getArea() {
    return areaInSqKm;
  }

  public void setArea(String area) {
    this.areaInSqKm = area;
  }

  public static List<Country> getListFromJson(Object json) {
    Log.d("Tiktzuki", "getListFromJson: "+json);
    CountryInfo countryInfo = (CountryInfo) json;
    List<Country> countries = new ArrayList<>();
//    Iterator<Object> itr = countryInfo.geonames.iterator();
//    while(itr.hasNext()){
//      Country obj = (Country) itr.next();
//      Country country = new Country(
//         obj.get("countryName").getAsString(),
//         "http://www.geonames.org/flags/x/" + String.format("%s",obj.get("countryCode")).toLowerCase() + ".gif",
//          obj.get("population").getAsLong(),
//          obj.get("areaInSqKm").getAsDouble()
//      );
//      countries.add(obj);
//    }
    return countries;
  }
  @Override
  public String toString() {
    return "{" +
        "name='" + countryName + '\'' +
        ", flagurl='" + flagurl + '\'' +
        ", population=" + population +
        ", area=" + areaInSqKm +
        '}';
  }
}
