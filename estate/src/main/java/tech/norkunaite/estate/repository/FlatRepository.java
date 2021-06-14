package tech.norkunaite.estate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tech.norkunaite.estate.model.Flat;

public interface FlatRepository extends PagingAndSortingRepository<Flat, Long> {

}
