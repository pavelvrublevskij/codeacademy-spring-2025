package lt.codeacademy.spring2025.eshop.common.mapper;

/**
 * Use this as standard mapper for all domain objects to entity and vice versa.
 * @param <D> - domain object
 * @param <T> - entity/model/pojo object
 */
public interface DomainEntityMapper<D, T> {

  T toEntity(D domain);
  D toDomain(T entity);
}
