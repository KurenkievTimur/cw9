package com.kurenkievtimur.cw9.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "attachment")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Attachment extends BaseIdEntity {
    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;
}
