package com.yossefaz.persistrest.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persistent_rest")
public class RestEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "url")
    private String url;

    @Column(name = "payload", columnDefinition = "json")
    private String payload;

    @Column(name = "headers", columnDefinition = "json")
    private String headers;

}
