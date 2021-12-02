package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.ConsumablesEntity;
import se.iths.springbootproject.repository.ConsumablesRepo;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ConsumablesService {

    private final ConsumablesRepo consumablesRepo;

    public ConsumablesService(ConsumablesRepo consumablesRepo)
    {
        this.consumablesRepo = consumablesRepo;
    }

    public ConsumablesEntity createConsumables(ConsumablesEntity consumablesEntity) {
        return consumablesRepo.save(consumablesEntity);
    }

    public void deleteConsumables(Long consumablesid) {
        ConsumablesEntity foundConsumables = consumablesRepo.findById(consumablesid).orElseThrow(EntityNotFoundException::new);
        consumablesRepo.deleteById(foundConsumables.getConsumablesid());
    }

    public Optional<ConsumablesEntity> findConsumablesById(Long consumablesid) {
        return consumablesRepo.findById(consumablesid);
    }

    public Iterable<ConsumablesEntity> findAllConsumables()
    {
        return consumablesRepo.findAll();
    }
}
