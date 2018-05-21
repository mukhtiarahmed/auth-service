package com.tenhawks.auth.domain;

import static com.fasterxml.jackson.annotation.JsonProperty.Access;
import static javax.persistence.FetchType.EAGER;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@Entity(name = "users")
public class User extends AbstractEntity {

  private static final long serialVersionUID = -3392490659474682931L;

  @NotNull
  @Length(min = 8, max = 200)
  @Column(name = "userName")
  private String userName;

  @NotNull
  @Length(min = 5, max = 200)
  @Column(name = "email_address")
  private String emailAddress;

  @NotNull
  @Column(name = "full_name")
  private String fullName;

  @Column(name = "profile_image")
  private String profileImage;

  @Column(name = "password")
  private String password;


  @NotNull
  @Column(name = "is_active")
  private Boolean active = Boolean.FALSE;

  @Column(name = "phone_number")
  private String phoneNumber;


  /**
   * The user roles.
   */
  @ManyToMany(cascade = { CascadeType.ALL }, fetch = EAGER)
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private List<Role> roles =new ArrayList<>();

}
