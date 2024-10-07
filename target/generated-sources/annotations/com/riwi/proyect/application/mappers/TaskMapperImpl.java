package com.riwi.proyect.application.mappers;

import com.riwi.proyect.application.dtos.requests.TaskRequestDto;
import com.riwi.proyect.application.dtos.responses.TaskResponseDto;
import com.riwi.proyect.domain.entities.Tasks;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-06T22:43:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Tasks toEntity(TaskRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Tasks.TasksBuilder<?, ?> tasks = Tasks.builder();

        tasks.name( requestDto.getName() );
        tasks.description( requestDto.getDescription() );

        return tasks.build();
    }

    @Override
    public TaskResponseDto toResponseDto(Tasks task) {
        if ( task == null ) {
            return null;
        }

        TaskResponseDto.TaskResponseDtoBuilder<?, ?> taskResponseDto = TaskResponseDto.builder();

        taskResponseDto.id( task.getId() );
        taskResponseDto.name( task.getName() );
        taskResponseDto.description( task.getDescription() );
        if ( task.getCreatedAt() != null ) {
            taskResponseDto.createdAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( task.getCreatedAt() ) );
        }

        return taskResponseDto.build();
    }
}
