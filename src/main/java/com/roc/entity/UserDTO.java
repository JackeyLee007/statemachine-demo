package com.roc.entity;

import lombok.Data;

/**
 * @author lipc
 */
@Data
public class UserDTO {
    long id;
    String name;

    Address address;
}
