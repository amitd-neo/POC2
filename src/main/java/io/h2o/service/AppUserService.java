package io.h2o.service;

import io.h2o.config.AppUserDetails;
import io.h2o.entity.AppUser;
import io.h2o.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByUsername(username);
        System.err.println("AppUser: "+user);
        user.orElseThrow(()->new UsernameNotFoundException("Not Found "+username));
        return user.map(AppUserDetails::new).get();
//        return new User("user","password", new ArrayList<>());
    }


    public AppUser saveUser(AppUser appUser) {
        return userRepository.save(appUser);
    }
}
