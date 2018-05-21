package com.tenhawks.auth.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Mukhtiar
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {

  private static final long serialVersionUID = 8414024608947196037L;

  private Meta status;

  private String message;

  private T data;


}
