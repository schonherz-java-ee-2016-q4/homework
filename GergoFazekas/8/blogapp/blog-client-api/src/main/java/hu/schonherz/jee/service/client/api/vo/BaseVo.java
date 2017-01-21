package hu.schonherz.jee.service.client.api.vo;

import java.io.Serializable;

public class BaseVo implements Serializable {

    private static final long serialVersionUID = -2768001384876339734L;

    private Long id;

    public BaseVo() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
