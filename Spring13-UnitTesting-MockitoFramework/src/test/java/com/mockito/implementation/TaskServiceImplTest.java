package com.mockito.implementation;

import com.mockito.dto.TaskDTO;
import com.mockito.entity.Task;
import com.mockito.mapper.TaskMapper;
import com.mockito.repository.TaskRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findByIdTest(long arg) {

        Task task = new Task();

        when(taskRepository.findById(arg)).thenReturn(java.util.Optional.of(task));
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        taskService.findById(arg);

        verify(taskRepository).findById(arg);
    }

}