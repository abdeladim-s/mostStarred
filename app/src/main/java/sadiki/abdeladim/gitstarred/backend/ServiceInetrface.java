package sadiki.abdeladim.gitstarred.backend;

import retrofit2.Call;
import retrofit2.http.GET;
import sadiki.abdeladim.gitstarred.model.RepoResponse;

public interface ServiceInetrface {

   @GET("/search/repositories?q=created:>2017-10-22&sort=stars&order=desc")
   Call<RepoResponse> getRepositories();
}
