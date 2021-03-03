package com.mockito.mapper;

import com.mockito.dto.ProjectDTO;
import com.mockito.entity.Project;
import com.mockito.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    private ModelMapper modelMapper;
    private ProjectRepository projectRepository;

    public ProjectMapper(ModelMapper modelMapper, ProjectRepository projectRepository) {
        this.modelMapper = modelMapper;
        this.projectRepository = projectRepository;
    }

    public Project convertToEntity(ProjectDTO dto){

        return modelMapper.map(dto,Project.class);
    }

    public ProjectDTO convertToDto(Project entity){

        return modelMapper.map(entity,ProjectDTO.class);
    }
}
