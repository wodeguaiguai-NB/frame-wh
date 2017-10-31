package com.team.framenb.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * users
 *
 * @author haohao
 * @create 2017/10/31 下午11:23
 **/

@Table(name="users")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer age;


}
