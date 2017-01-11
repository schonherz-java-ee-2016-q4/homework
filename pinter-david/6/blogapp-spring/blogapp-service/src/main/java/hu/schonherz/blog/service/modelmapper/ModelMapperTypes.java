/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.blog.service.modelmapper;

import hu.schonherz.blog.service.api.user.vo.UserVO;
import java.lang.reflect.Type;
import java.util.Collection;
import org.modelmapper.TypeToken;

/**
 *
 * @author pintyo
 */
public final class ModelMapperTypes {

    public static final Type USER_VO_COLLECTION_TYPE
            = new TypeToken<Collection<UserVO>>() {}.getType();
    
    
}
