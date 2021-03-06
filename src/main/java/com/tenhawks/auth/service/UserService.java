package com.tenhawks.auth.service;



import javax.validation.constraints.NotNull;

import com.tenhawks.auth.domain.User;
import com.tenhawks.auth.bean.UserDetail;
/**
 * @author Mukhtiar Ahmed
 */
public interface UserService {	
 
  /**
   * <p>
   *   Saves provided {@link NotNull} {@link User} object to database.
   * </p>
   *
   * @param user {@link User}
   */
  void saveUser(final User user);

  
  void registerUser(final User user);

  
  UserDetail getUserDetailByUserName(final String userName);

  
  User getUserByEmail(String email);


}