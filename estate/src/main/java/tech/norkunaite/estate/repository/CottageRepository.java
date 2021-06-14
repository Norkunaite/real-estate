package tech.norkunaite.estate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tech.norkunaite.estate.model.Cottage;

public interface CottageRepository extends PagingAndSortingRepository<Cottage, Long> {

}
