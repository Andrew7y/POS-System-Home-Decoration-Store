package com.cp.kku.housely.loader;

import com.cp.kku.housely.model.User;
import com.cp.kku.housely.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args){
        User admin = new User();
        userRepository.findByUsername("admin").ifPresentOrElse(
                user -> {
                    admin.setId(user.getId());
                    admin.setUsername(user.getUsername());
                    admin.setPassword(user.getPassword());
                    admin.setRole(user.getRole());
                },
                () -> {
                    admin.setUsername("admin");
                    admin.setPassword(passwordEncoder.encode("admin"));
                    admin.setRole("ADMIN");
                    userRepository.save(admin);
                }
        );
    }
}
