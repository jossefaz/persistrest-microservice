package com.yossefaz.persistrest.model;


import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "persistent_rest")
@TypeDef(
        name = "jsonb-node",
        typeClass = JsonNodeBinaryType.class
)
public class RestEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "url")
    private String url;

    @Type(type = "jsonb-node")
    @Column(name = "payload", columnDefinition = "json")
    private JsonNode payload;

    @Type(type = "jsonb-node")
    @Column(name = "headers", columnDefinition = "json")
    private JsonNode headers;

}
