package com.abreu.blog.service;
import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.payload.UserDto;
import lombok.AllArgsConstructor;
import com.abreu.blog.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.abreu.blog.repository.UserRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto getUser(int id) {
        User user = this.repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("user","id",id));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.repository.findAll();

        return users.stream().map(this::userToDto).toList();
    }

    @Override
    public UserDto save(UserDto userDto) {

        User user = this.dtoToUser(userDto);
        User savedUser = this.repository.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto update(int id, UserDto userDto) {
        User user = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("user","id",id));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        User updatedUser = this.repository.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public void delete(int id) {
        User user = this.repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("user","id",id));

        repository.delete(user);
    }


    public User dtoToUser(UserDto userDto){
        return this.modelMapper.map(userDto,User.class);
    }

    public UserDto userToDto(User user){
        return this.modelMapper.map(user,UserDto.class);
    }
}


