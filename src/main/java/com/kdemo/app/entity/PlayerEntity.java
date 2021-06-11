package com.kdemo.app.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}
