package com.sigei.Skyline_Shops.service.image;

import com.sigei.Skyline_Shops.dblayer.entity.Image;
import com.sigei.Skyline_Shops.dto.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file,  Long imageId);
}
