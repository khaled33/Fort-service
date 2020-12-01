package com.sid.Fort.UploadImage.Dao;

import com.sid.Fort.UploadImage.payload.UploadFileResponse;
import com.sid.Fort.UserDetails.Entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadImageRipository extends JpaRepository<UploadFileResponse,Long> {

    UploadFileResponse getUploadFileResponseByAppUser(AppUser appUser);
}
