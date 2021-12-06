package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.ResourcesEntity;
import se.iths.springbootproject.repository.ResourcesRepo;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ResourcesService {

    private final ResourcesRepo resourcesRepo;

    public ResourcesService(ResourcesRepo resourcesRepo) {
        this.resourcesRepo = resourcesRepo;
    }

    public ResourcesEntity createResources (ResourcesEntity resourcesEntity){
        return resourcesRepo.save(resourcesEntity);
    }

    public void deleteResources (Long resourcesId){
        ResourcesEntity foundResources = resourcesRepo.findById(resourcesId).orElseThrow(EntityNotFoundException::new);
        resourcesRepo.deleteById(foundResources.getResourcesid());
    }

    public Optional<ResourcesEntity> findResourcesById(Long resourcesId) {
        return resourcesRepo.findById(resourcesId);
    }

    public Iterable<ResourcesEntity> findAllResources() {
        return resourcesRepo.findAll();
    }
}
