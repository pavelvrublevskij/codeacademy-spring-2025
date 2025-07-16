package lt.codeacademy.spring2025.eshop.common.mapper;

/**
 * Use this as standard mapper for all domain objects to DTOs and vice versa.
 * @param <D> - domain object
 * @param <DTO> - DTO object
 */
public interface DomainDtoMapper<D, DTO> {

  DTO toDto(D domain);
  D toDomain(DTO dto);
}
