package dev.alex.api.service.impl;

import dev.alex.api.model.Profile;
import dev.alex.api.repository.ProfileRepository;
import dev.alex.api.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findById(Long id) {
        return profileRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Profile findByDocument(String document) {
        if(!profileRepository.existsByDocument(document)) {
            throw  new IllegalArgumentException(("Usuario não encontrado"));
        }
        return profileRepository.findByDocument(document);
    }


    @Override
    public Profile create(Profile profileToCreate) {
        //if(profileToCreate.getId() != null && profileRepository.existsById(profileToCreate.getId())) {
            if(profileRepository.existsByDocument(profileToCreate.getDocument())) {
                throw  new IllegalArgumentException(("Usuario ja existe"));
            }

        //}
        //AQUI ACIMA VAI MUDAR DEPOIS
        return profileRepository.save(profileToCreate);
    }
}
