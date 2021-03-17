package course.labs.changeratecurrentcy;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GithubApi {
  String ENDPONT = "https://api.github.com";

  @GET("user/repos?per_page=2")
  Single<List<GithubRepos>> getRepos();

  @GET("/repos/TikTzuki/TikTzuki/issues")
  Single<List<GithubIssue>> getIssues();

  @POST
  Single<ResponseBody> postComment(@Url String url, @Body GithubIssue issue);
}
