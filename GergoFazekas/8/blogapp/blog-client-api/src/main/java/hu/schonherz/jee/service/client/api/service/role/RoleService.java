package hu.schonherz.jee.service.client.api.service.role;

import hu.schonherz.jee.service.client.api.vo.Role;

public interface RoleService {
    Role findByName(String name);
    Role save(Role name);
}
