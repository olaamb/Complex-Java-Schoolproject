package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.BackpackEntity;
import se.iths.springbootproject.repository.BackpackRepo;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BackpackService {

    private final BackpackRepo backpackRepo;

    public BackpackService(BackpackRepo backpackRepo)
    {
        this.backpackRepo = backpackRepo;
    }

    public BackpackEntity createBackpack(BackpackEntity backpackEntity) {
        return backpackRepo.save(backpackEntity);
    }

    public void deleteBackpack(Long backpackid) {
        BackpackEntity foundBackpack = backpackRepo.findById(backpackid).orElseThrow(EntityNotFoundException::new);
        backpackRepo.deleteById(foundBackpack.getBackpackid());
    }

    public Optional<BackpackEntity> findBackpackById(Long backpackid) {
        return backpackRepo.findById(backpackid);
    }

    public Iterable<BackpackEntity> findAllBackpacks() {
        return backpackRepo.findAll();
    }
}
