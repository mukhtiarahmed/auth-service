package com.tenhawks.auth.bean;

import com.tenhawks.auth.domain.Role;
import com.tenhawks.auth.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * This class has utilities related to user's object
 * @author Arsalan.Ahmed
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserUtils {
	
	public static boolean isAdminUser(User user ){
		boolean isAdmin = false; // Nagative approach is batter
		
		if( user != null && !CollectionUtils.isEmpty(user.getRoles())){
			for(Role role : user.getRoles() ){
				if( role != null && ( role.equals(RoleEnum.ROLE_ADMIN) || role.equals(RoleEnum.ROLE_SUPER_ADMIN) ) ){
					isAdmin = true;
					break;
				}
			}
		}
		
		return isAdmin;
	}
	
	public static boolean isSuperAdminUser(User user ){
		boolean isSuperAdmin = false; // Nagative approach is batter
		
		if(user!=null && user.getRoles()!=null){
			for(Role role : user.getRoles() ){
				if(role!=null && role.equals(RoleEnum.ROLE_SUPER_ADMIN)){
					isSuperAdmin = true;
					break;
				}
			}
		}
		
		return isSuperAdmin;
	}

}
