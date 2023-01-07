package com.ecom.app.ws.services;

import com.ecom.app.ws.shared.dto.UserDetailDto;

public interface UserDetailService {
    UserDetailDto createUserDetail(UserDetailDto userDetailDto, String userPaymentId);
}
