package hu.schonherz.java.training.kovtamas.serviceapi.user.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Collection;
import java.util.List;

public class UserContainer {

    @SerializedName("results")
    @Expose
    private Collection<UserVo> users;

    public UserContainer() {
    }

    public UserContainer(Collection<UserVo> users) {
        this.users = users;
    }

    public Collection<UserVo> getUsers() {
        return users;
    }

    public void setUsers(List<UserVo> users) {
        this.users = users;
    }

}
