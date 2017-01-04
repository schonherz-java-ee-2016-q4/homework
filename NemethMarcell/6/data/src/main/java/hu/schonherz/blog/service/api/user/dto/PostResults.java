package hu.schonherz.blog.service.api.user.dto;

import java.util.ArrayList;
import java.util.List;

public class PostResults {
    private List<PostDTO> results = new ArrayList<>();

    public List<PostDTO> getResults() {
        return results;
    }

    public void setResults(List<PostDTO> results) {
        this.results = results;
    }
    
    
    
}
