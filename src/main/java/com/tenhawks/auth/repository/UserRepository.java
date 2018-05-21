package com.tenhawks.auth.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tenhawks.auth.domain.User;

/**
 * @author Mukhtiar Ahmed
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
  /**
   * <p>
   *   Returns {@link User} object for given {@code userName} and only if it's active, otherwise {@code null}
   * </p>
   *
   * @param userName
   *
   * @return {@link User}
   */
  User findByUserNameAndActiveTrue(final String userName);

  /**
   * <p>
   *   Returns {@link User} object for given {@code emailAddress} otherwise {@code null}
   * </p>
   * @param emailAddress
   * @return {@link User}
   */
  User findByEmailAddress(final String emailAddress);


}
