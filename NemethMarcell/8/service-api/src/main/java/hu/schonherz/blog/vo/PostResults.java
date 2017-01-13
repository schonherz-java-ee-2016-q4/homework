package hu.schonherz.blog.vo;

import hu.schonherz.blog.core.domain.PostEntity;

import java.util.ArrayList;
import java.util.List;

public class PostResults {
    private List<PostVO> results = new ArrayList<>();

    public List<PostVO> getResults() {
        return results;
    }

    public void setResults(List<PostVO> results) {
        this.results = results;
    }
    
    
    
}
