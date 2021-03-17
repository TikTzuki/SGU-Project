package course.labs.changeratecurrentcy;

import com.google.gson.annotations.SerializedName;

public class GithubIssue {
  String id;
  String title;
  String comments_url;

  @SerializedName("body")
  String comment;

  @Override
  public String toString() {
    return "GithubIssue{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        '}';
  }
}
