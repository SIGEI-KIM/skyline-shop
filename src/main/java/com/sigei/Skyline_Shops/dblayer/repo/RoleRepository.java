package com.sigei.Skyline_Shops.dblayer.repo;

import com.sigei.Skyline_Shops.dblayer.entity.Cart;
import com.sigei.Skyline_Shops.dblayer.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
//    Collection<Object> findByName(String role);
//    Collection<Object> findByName(String role);
       Optional<Role> findByName(String name);
}
