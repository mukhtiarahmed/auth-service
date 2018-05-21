package com.tenhawks.auth.service;


import javax.validation.constraints.NotNull;

import com.tenhawks.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenhawks.auth.bean.RoleEnum;
import com.tenhawks.auth.domain.Role;
import com.tenhawks.auth.domain.User;
import com.tenhawks.auth.bean.UserDetail;
import com.tenhawks.auth.exception.AlreadyRegisteredException;
import com.tenhawks.auth.repository.UserRepository;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Mukhtiar Ahmed
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    /**
     * <p>
     * Saves provided {@link NotNull} {@link User} object to database.
     * </p>
     *
     * @param user {@link User}
     */
    @Override
    public void saveUser(@NotNull final User user) {
        userRepository.save(user);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetail getUserDetailByUserName(String userName) {

        User user = userRepository.findByUserNameAndActiveTrue(userName);

        UserDetail userDetail = null;
        if (user != null) {
            userDetail = new UserDetail();
            userDetail.setEmailAddress(user.getEmailAddress());
            userDetail.setPassword(user.getPassword());
            userDetail.setFullName(user.getFullName());
            userDetail.setEnabled(user.getActive());
            userDetail.setRoles(user.getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList()));
            userDetail.setPhoneNumber(user.getPhoneNumber());
            userDetail.setProfileImage(user.getProfileImage());
        }

        return userDetail;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public User getUserByEmail(String email) {
        return userRepository.findByEmailAddress(email);
    }


    @Override
    public void registerUser(User user) {
        User exits = userRepository.findByEmailAddress(user.getEmailAddress());

        if (exits == null) {
            user.setRoles(Arrays.asList(roleRepository.findByRoleName(RoleEnum.ROLE_USER.name())));
            saveUser(user);
        } else {
            throw new AlreadyRegisteredException("You seem to be already registered.");

        }
    }
}
