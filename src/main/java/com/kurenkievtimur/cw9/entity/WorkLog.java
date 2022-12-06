package com.kurenkievtimur.cw9.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_log")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WorkLog extends BaseIdEntity {
    @Column(name = "created_at")
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "time", length = 6)
    String time;

    @Column(name = "description", length = 50)
    String description;

    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;
}
