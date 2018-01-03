package sadiki.abdeladim.gitstarred.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Abdeladim SADIKI on 01/01/2018.
 */

public class RepoResponse {

    @SerializedName("items")
    @Expose
    private List<Repository> repositories;

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }
}
