package sadiki.abdeladim.gitstarred.model;

/**
 * Created by Abdeladim SADIKI on 01/01/2018.
 */

public class Repository {

    private String repoName;
    private String repoDesc;
    private String avatar;
    private String repoOwner;
    private String nbOfStars;

    public Repository(String repoName, String repoDesc, String avatar, String repoOwner, String nbOfStars) {
        this.repoName = repoName;
        this.repoDesc = repoDesc;
        this.avatar = avatar;
        this.repoOwner = repoOwner;
        this.nbOfStars = nbOfStars;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoDesc() {
        return repoDesc;
    }

    public void setRepoDesc(String repoDesc) {
        this.repoDesc = repoDesc;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRepoOwner() {
        return repoOwner;
    }

    public void setRepoOwner(String repoOwner) {
        this.repoOwner = repoOwner;
    }

    public String getNbOfStars() {
        return nbOfStars;
    }

    public void setNbOfStars(String nbOfStars) {
        this.nbOfStars = nbOfStars;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "repoName='" + repoName + '\'' +
                ", repoDesc='" + repoDesc + '\'' +
                ", avatar='" + avatar + '\'' +
                ", repoOwner='" + repoOwner + '\'' +
                ", nbOfStars='" + nbOfStars + '\'' +
                '}';
    }
}
