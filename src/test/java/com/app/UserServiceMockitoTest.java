package com.app;

import com.app.login.domain.User;
import com.app.login.repository.AuthorityRepository;
import com.app.login.repository.UserRepository;
import com.app.login.service.UserService;
import com.app.login.service.dto.UserDTO;
import com.app.login.service.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 2018/3/26 0026.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceMockitoTest {

    @Mock
    private UserRepository  userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private  AuthorityRepository authorityRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        ArrayList<User> users=  new ArrayList<User>();
        User mockuser= createUser();
        UserDTO mockuserDto=new UserDTO();
        users.add(mockuser);
        Optional<User> optuser=Optional.of(mockuser);
        Optional<UserDTO> userDTOOptional=Optional.of(mockuserDto);
        when(userRepository.findOne(any(Long.class))).thenReturn(mockuser);
        when(userRepository.findAll()).thenReturn(users);
        when(userRepository.findOneByEmail(any(String.class))).thenReturn(optuser);

        userService=new UserService(userRepository,passwordEncoder, authorityRepository);
    }

    @Test
    public void updateUserTest()
    {
        //assume
        UserDTO userDTO=new UserMapper().userToUserDTO(createUser());

        //act
        Optional<UserDTO> updateUser = userService.updateUser(userDTO);

        //assert
        assertNotNull(updateUser);
    }

    private User createUser() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Peter");
        user.setLastName("Liu");
        user.setPassword("batman");
        user.setCreatedDate(Instant.now());
        user.setEmail("xxxx@hotmail.com");
        user.setIpAddress("127.0.0.1");
        user.setLogin("Peter");

        return user;
    }
}