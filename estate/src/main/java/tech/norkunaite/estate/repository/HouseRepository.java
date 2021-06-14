package tech.norkunaite.estate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import tech.norkunaite.estate.model.House;

public interface HouseRepository extends PagingAndSortingRepository<House, Long> {

}
