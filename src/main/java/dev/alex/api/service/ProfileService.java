package dev.alex.api.service;

import dev.alex.api.model.Profile;

public interface ProfileService {

    Profile findById(Long id);

    Profile findByDocument(String document);

    Profile create(Profile profileToCreate);

}
