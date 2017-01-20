package hu.schonherz.blog.vo;

import hu.schonherz.blog.core.domain.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserResults {
    private List<UserVO> results = new ArrayList<>();
    
    
    public List<UserVO> getResults() {
        return results;
        }

      
        public void setResults(List<UserVO> results) {
        this.results = results;
        }
}
