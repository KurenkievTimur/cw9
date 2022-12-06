package com.kurenkievtimur.cw9.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class BaseIdEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
