package com.riwi.proyect.application.mappers;

import com.riwi.proyect.application.dtos.requests.UserRequestDto;
import com.riwi.proyect.application.dtos.responses.UserResponseDto;
import com.riwi.proyect.domain.entities.Users;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-06T22:47:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public Users toEntity(UserRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Users.UsersBuilder<?, ?> users = Users.builder();

        users.username( requestDto.getUsername() );
        users.email( requestDto.getEmail() );
        users.password( requestDto.getPassword() );

        return users.build();
    }

    @Override
    public UserResponseDto toResponseDto(Users user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder<?, ?> userResponseDto = UserResponseDto.builder();

        userResponseDto.createdBy( user.getCreatedBy() );
        userResponseDto.updatedBy( user.getUpdatedBy() );
        userResponseDto.id( user.getId() );
        userResponseDto.username( user.getUsername() );
        userResponseDto.email( user.getEmail() );
        if ( user.getRole() != null ) {
            userResponseDto.role( user.getRole().name() );
        }

        return userResponseDto.build();
    }
}
