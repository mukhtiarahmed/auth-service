package com.tenhawks.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Mukhtiar Ahmed
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "roles")
public class Role extends AbstractEntity {
  private static final long serialVersionUID = -1077836392559104967L;

  @NotNull
  @Length(min = 3, max = 50)
  @Column(name = "role_name")
  private String roleName;
}
