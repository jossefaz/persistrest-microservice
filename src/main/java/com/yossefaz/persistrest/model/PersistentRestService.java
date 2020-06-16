package com.yossefaz.persistrest.model;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface PersistentRestService extends CrudRepository<RestEntity, UUID> {}
