package course.labs.changeratecurrentcy;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class GithubRepoDeserializer implements JsonDeserializer<GithubRepos> {
  @Override
  public GithubRepos deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      GithubRepos githubRepos = new GithubRepos();

    JsonObject repoJsonObject = json.getAsJsonObject();
    githubRepos.name = repoJsonObject.get("name").getAsString();
    githubRepos.url = repoJsonObject.get("url").getAsString();

    JsonElement ownerJsonElement = repoJsonObject.get("owner");
    JsonObject ownerJsonObject = ownerJsonElement.getAsJsonObject();
    githubRepos.owner = ownerJsonObject.get("login").getAsString();

    return githubRepos;
  }
}
