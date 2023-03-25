package dev.siraev.security;

import dev.siraev.models.User;
import dev.siraev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
        return SecurityUser.fromUser(user);
    }
    public User findByUserName(String username){
        return userRepository.findByUsername(username).orElse(new User());
    }
    public User getUser(Long id){
        Optional<User> userFromDB = userRepository.findById(id);
        return userFromDB.orElse(new User());
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
