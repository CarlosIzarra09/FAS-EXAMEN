package com.misviajes.lodging.repository;
import java.util.Optional;


import com.misviajes.lodging.entity.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, Long> {
    Optional<Lodging> getLodgingById(Long id);
}
