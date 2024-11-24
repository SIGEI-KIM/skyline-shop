package com.sigei.Skyline_Shops.service.user;

import com.sigei.Skyline_Shops.dblayer.entity.User;
import com.sigei.Skyline_Shops.dto.UserDto;
import com.sigei.Skyline_Shops.model.request.CreateUserRequest;
import com.sigei.Skyline_Shops.model.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    User createUser(CreateUserRequest request);
    User updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertUserToDto(User user);

    User getAuthenticatedUser();
}
