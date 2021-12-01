package se.iths.springbootproject.service;

import org.springframework.stereotype.Service;
import se.iths.springbootproject.entity.ToolsEntity;
import se.iths.springbootproject.repository.ToolsRepo;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ToolsService {

    private final ToolsRepo toolsRepo;

    public ToolsService(ToolsRepo toolsRepo) {
        this.toolsRepo = toolsRepo;
    }

    public ToolsEntity createTools (ToolsEntity toolsEntity){
        return toolsRepo.save(toolsEntity);
    }

    public void deleteTools (Long toolsId){
        ToolsEntity foundTools = toolsRepo.findById(toolsId).orElseThrow(EntityNotFoundException::new);
        toolsRepo.deleteById(foundTools.getToolsid());
    }

    public Optional<ToolsEntity> findToolsById(Long toolsId) {
        return toolsRepo.findById(toolsId);
    }

    public Iterable<ToolsEntity> findAllTools() {
        return toolsRepo.findAll();
    }
}
