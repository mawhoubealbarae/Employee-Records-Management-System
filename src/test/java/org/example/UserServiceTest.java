package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        String username = "testuser";
        String password = "password";
        Set<String> roleNames = new HashSet<>();
        roleNames.add("ROLE_USER");

        Role role = new Role();
        role.setName("ROLE_USER");

        when(roleRepository.findByName("ROLE_USER")).thenReturn(role);
        when(passwordEncoder.encode(password)).thenReturn("encodedPassword");

        User user = new User();
        user.setUsername(username);
        user.setPassword("encodedPassword");
        user.setRoles(Set.of(role));

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(username, password, roleNames);

        assertEquals(username, createdUser.getUsername());
        assertEquals("encodedPassword", createdUser.getPassword());
        assertEquals(1, createdUser.getRoles().size());
        assertEquals("ROLE_USER", createdUser.getRoles().iterator().next().getName());

        verify(roleRepository, times(1)).findByName("ROLE_USER");
        verify(passwordEncoder, times(1)).encode(password);
        verify(userRepository, times(1)).save(any(User.class));
    }
}