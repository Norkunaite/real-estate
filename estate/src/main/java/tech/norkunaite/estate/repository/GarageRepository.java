package tech.norkunaite.estate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tech.norkunaite.estate.model.Garage;

public interface GarageRepository extends PagingAndSortingRepository<Garage, Long> {

}
