package com.yossefaz.persistrest.model;


import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.http.HttpMethod;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "persistent_rest")
@TypeDef(name = "jsonb-node",typeClass = JsonNodeBinaryType.class)
@TypeDef(name = "pgsql_enum",typeClass = PostgreSQLEnumType.class)
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

    @Enumerated(EnumType.STRING)
    @Column(name="method", columnDefinition = "methods")
    @Type( type = "pgsql_enum" )
    private HttpMethod method;

}
