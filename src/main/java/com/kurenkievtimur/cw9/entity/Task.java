package com.kurenkievtimur.cw9.entity;

import com.kurenkievtimur.cw9.util.enums.TaskStatusType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Task extends BaseIdEntity {
    @Column(name = "created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "name", length = 20)
    String name;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    TaskStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "task")
    List<WorkLog> tasks;

    @OneToMany(mappedBy = "task")
    List<Attachment> attachments;
}
