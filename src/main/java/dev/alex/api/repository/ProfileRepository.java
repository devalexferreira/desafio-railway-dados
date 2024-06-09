package dev.alex.api.repository;

import dev.alex.api.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByDocument(String document);

    Profile findByDocument(String document);

}
