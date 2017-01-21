package hu.schonherz.jee.service.impl.role;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.schonherz.jee.core.dao.RoleDao;
import hu.schonherz.jee.core.entity.RoleEntity;
import hu.schonherz.jee.service.client.api.service.role.RoleServiceLocal;
import hu.schonherz.jee.service.client.api.service.role.RoleServiceRemote;
import hu.schonherz.jee.service.client.api.vo.Role;
import hu.schonherz.jee.service.mapper.role.RoleVoMapper;

@Stateless(mappedName = "RoleService")
@Remote(RoleServiceRemote.class)
@Local(RoleServiceLocal.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RoleServiceBean implements RoleServiceLocal, RoleServiceRemote{

    @Autowired
    RoleDao roleDao;
    
    @Override
    public Role findByName(String name) {
        RoleEntity findByName = roleDao.findByName(name);
        return RoleVoMapper.toVo(findByName);
    }
    
    @Override
    public Role save(Role name) {
        RoleEntity roleEntity = roleDao.save(RoleVoMapper.toEntity(name));
        return RoleVoMapper.toVo(roleEntity);
    }
    
}
