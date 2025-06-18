//package com.kiranaryal.journal_app.service;
//
//import com.kiranaryal.journal_app.entity.User;
//import com.kiranaryal.journal_app.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
////@SpringBootTest
////public class UserDetailsServiceImplTests {
//
//
//public class UserDetailsServiceImplTests {
//
//    @InjectMocks
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    //before any test run this method
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void loadUserByUsernameTest() {
//        when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("asmita").password("al;skjdf").roles(new ArrayList<>()).build());
//        UserDetails user = userDetailsService.loadUserByUsername("asmita");
//        Assertions.assertNotNull(user);
//    }
//}
