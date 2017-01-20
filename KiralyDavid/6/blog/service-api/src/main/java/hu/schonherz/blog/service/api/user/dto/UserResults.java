package hu.schonherz.blog.service.api.user.dto;


import java.util.ArrayList;
import java.util.List;

public class UserResults {

    private List<UserDTO> results = new ArrayList<>();

    public List<UserDTO> getResults() {
        return results;
    }

    public void setResults(List<UserDTO> results) {
        this.results = results;
    }
}
