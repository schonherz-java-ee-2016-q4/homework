package hu.schonherz.blog.service.api.user.service;

import java.util.Collection;

import hu.schonherz.blog.data.dao.PostDAO;
import hu.schonherz.blog.data.dto.PostDTO;


public class PostResult {
    private Collection<PostDTO> results = new PostDAO().findAll();

    public Collection<PostDTO> getResults() {
        return results;
    }
}
