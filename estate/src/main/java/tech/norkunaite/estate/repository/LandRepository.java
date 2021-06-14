package tech.norkunaite.estate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tech.norkunaite.estate.model.Land;

public interface LandRepository extends PagingAndSortingRepository<Land, Long> {

}
