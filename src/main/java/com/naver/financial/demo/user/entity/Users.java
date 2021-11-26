package com.naver.financial.demo.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Data
@Entity
public class Users {
    @Id
    private String id;

    private String name;

    private Integer point;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
