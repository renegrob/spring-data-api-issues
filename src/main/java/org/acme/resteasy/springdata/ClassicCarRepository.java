package org.acme.resteasy.springdata;

import org.acme.resteasy.entities.ClassicCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassicCarRepository extends JpaRepository<ClassicCarEntity, String> {

    /**
     * Camel case issue
     * @param carBrandId
     * @return a list of {@link ClassicCarEntity}
     */
    List<ClassicCarEntity> findByCarBrandId(String carBrandId);

    /**
     * Return type issue
     * @return String list of all brand ids used by classic cars
     */
    @Query("SELECT DISTINCT car.carBrand.id FROM ClassicCarEntity car")
    List<String> findAllUsedCarBrandIds();
}
