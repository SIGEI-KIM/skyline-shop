package com.sigei.Skyline_Shops.dblayer.repo;

import com.sigei.Skyline_Shops.dblayer.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByProductId(Long id);
}
