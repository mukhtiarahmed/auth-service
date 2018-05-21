package com.tenhawks.auth.repository;


import com.tenhawks.auth.domain.Role;
import com.tenhawks.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mukhtiar
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

  /**
   *
   * @param roleName
   * @return
   */
  Role findByRoleName(String roleName);

}
