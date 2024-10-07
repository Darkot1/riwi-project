package com.riwi.proyect.application.mappers;

import com.riwi.proyect.application.dtos.requests.ProjectRequestDto;
import com.riwi.proyect.application.dtos.requests.TaskRequestDto;
import com.riwi.proyect.application.dtos.responses.ProjectResponseDto;
import com.riwi.proyect.application.dtos.responses.TaskResponseDto;
import com.riwi.proyect.domain.entities.Project;
import com.riwi.proyect.domain.entities.Tasks;
import com.riwi.proyect.domain.entities.Users;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-06T22:43:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project toEntity(ProjectRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Project.ProjectBuilder<?, ?> project = Project.builder();

        project.name( requestDto.getName() );
        project.description( requestDto.getDescription() );
        project.tasks( taskRequestDtoListToTasksList( requestDto.getTasks() ) );

        return project.build();
    }

    @Override
    public ProjectResponseDto toResponseDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectResponseDto.ProjectResponseDtoBuilder<?, ?> projectResponseDto = ProjectResponseDto.builder();

        projectResponseDto.name( project.getName() );
        projectResponseDto.description( project.getDescription() );
        Set<Users> set = project.getUsers();
        if ( set != null ) {
            projectResponseDto.users( new LinkedHashSet<Users>( set ) );
        }
        projectResponseDto.tasks( tasksListToTaskResponseDtoList( project.getTasks() ) );
        if ( project.getCreatedAt() != null ) {
            projectResponseDto.createdAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( project.getCreatedAt() ) );
        }

        return projectResponseDto.build();
    }

    protected Tasks taskRequestDtoToTasks(TaskRequestDto taskRequestDto) {
        if ( taskRequestDto == null ) {
            return null;
        }

        Tasks.TasksBuilder<?, ?> tasks = Tasks.builder();

        tasks.name( taskRequestDto.getName() );
        tasks.description( taskRequestDto.getDescription() );

        return tasks.build();
    }

    protected List<Tasks> taskRequestDtoListToTasksList(List<TaskRequestDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Tasks> list1 = new ArrayList<Tasks>( list.size() );
        for ( TaskRequestDto taskRequestDto : list ) {
            list1.add( taskRequestDtoToTasks( taskRequestDto ) );
        }

        return list1;
    }

    protected TaskResponseDto tasksToTaskResponseDto(Tasks tasks) {
        if ( tasks == null ) {
            return null;
        }

        TaskResponseDto.TaskResponseDtoBuilder<?, ?> taskResponseDto = TaskResponseDto.builder();

        taskResponseDto.id( tasks.getId() );
        taskResponseDto.name( tasks.getName() );
        taskResponseDto.description( tasks.getDescription() );
        if ( tasks.getCreatedAt() != null ) {
            taskResponseDto.createdAt( DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( tasks.getCreatedAt() ) );
        }

        return taskResponseDto.build();
    }

    protected List<TaskResponseDto> tasksListToTaskResponseDtoList(List<Tasks> list) {
        if ( list == null ) {
            return null;
        }

        List<TaskResponseDto> list1 = new ArrayList<TaskResponseDto>( list.size() );
        for ( Tasks tasks : list ) {
            list1.add( tasksToTaskResponseDto( tasks ) );
        }

        return list1;
    }
}
