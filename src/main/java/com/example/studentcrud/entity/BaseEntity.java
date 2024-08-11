package com.example.studentcrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Base abstract class for entities which will hold definitions for created, last modified, created by,
 * last modified by attributes.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    @Column(name = "CREATE_AT", nullable = false)
    @JsonIgnore
    private LocalDateTime createAt;

    @Column(name = "UPDATE_AT", nullable = false)
    @JsonIgnore
    private LocalDateTime updateAt;

    @PrePersist
    protected void onCreateAt() {
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdateAt() {
        this.updateAt = LocalDateTime.now();
    }
}

