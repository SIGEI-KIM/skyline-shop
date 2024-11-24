package com.sigei.Skyline_Shops.data;

import com.sigei.Skyline_Shops.dblayer.entity.User;
import com.sigei.Skyline_Shops.dblayer.entity.Role; // Import Role if it's defined
import com.sigei.Skyline_Shops.dblayer.repo.RoleRepository;
import com.sigei.Skyline_Shops.dblayer.repo.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Transactional
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Set<String> defaultRoles = Set.of("ROLE_ADMIN", "ROLE_USER");
        createDefaultUserIfNotExists();
        createDefaultRolesIfNotExists(defaultRoles);
        createDefaultAdminIfNotExists();
    }

    private void createDefaultUserIfNotExists() {
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        for (int i = 1; i <= 5; i++) {
            String defaultEmail = "user" + i + "@gmail.com";
            if (userRepository.existsByEmail(defaultEmail)) {
                continue;
            }
            User user = new User();
            user.setFirstName("The user");
            user.setLastName("User" + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(userRole));
            userRepository.save(user);
            System.out.println("Default user " + i + " created successfully");
        }
    }

    private void createDefaultAdminIfNotExists() {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN").get();
        for (int i = 1; i <= 5; i++) {
            String defaultEmail = "Admin" + i + "@gmail.com";
            if (userRepository.existsByEmail(defaultEmail)) {
                continue;
            }
            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin" + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(adminRole));
            userRepository.save(user);
            System.out.println("Default admin user " + i + " created successfully");
        }
    }

    private void createDefaultRolesIfNotExists(Set<String> roles) {
        roles.stream()
                .filter(role -> roleRepository.findByName(role).isEmpty())
                .map(Role::new) // Ensure Role class exists and has a constructor
                .forEach(roleRepository::save);
    }
}




//package com.sigei.Skyline_Shops.data;
//
//import com.sigei.Skyline_Shops.dblayer.entity.User;
//import com.sigei.Skyline_Shops.dblayer.repo.RoleRepository;
//import com.sigei.Skyline_Shops.dblayer.repo.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        Set<String> defaultRoles = Set.of("ROLE_ADMIN", "ROLE_USER");
//        createDefaultRolesIfNotExists(defaultRoles);
//        createDefaultUserIfNotExists();
//    }
//    private void createDefaultUserIfNotExists() {
//        for(int i = 1; i<=5; i++){
//            String defaultEmail = "user" + i + "@gmail.com";
//            if(userRepository.existsByEmail(defaultEmail)){
//                continue;
//            }
//            User user = new User();
//            user.setFirstName("The user");
//            user.setLastName("User" + i);
//            user.setEmail(defaultEmail);
//            user.setPassword(passwordEncoder.encode("123456"));
//            userRepository.save(user);
//            System.out.println("Default vet user "  + i + " created successfully");
//        }
//    }
//
//    private void createDefaultRolesIfNotExists(Set<String> roles){
//        roles.stream()
//                .filter(role -> roleRepository.findByName(role).isEmpty())
//                .map(Role:: new).forEach(roleRepository::save);
//    }
//}
