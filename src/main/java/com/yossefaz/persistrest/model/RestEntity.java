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

    public static RestEntityBuilder builder() {
        return new RestEntityBuilder();
    }

    public static class RestEntityBuilder {
        private UUID id;
        private String url;
        private JsonNode payload;
        private JsonNode headers;
        private HttpMethod method;

        RestEntityBuilder() {
        }

        public RestEntityBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public RestEntityBuilder url(String url) {
            this.url = url;
            return this;
        }

        public RestEntityBuilder payload(JsonNode payload) {
            this.payload = payload;
            return this;
        }

        public RestEntityBuilder headers(JsonNode headers) {
            this.headers = headers;
            return this;
        }

        public RestEntityBuilder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        public RestEntity build() {
            return new RestEntity(id, url, payload, headers, method);
        }

        public String toString() {
            return "RestEntity.RestEntityBuilder(id=" + this.id + ", url=" + this.url + ", payload=" + this.payload + ", headers=" + this.headers + ", method=" + this.method + ")";
        }
    }
}
