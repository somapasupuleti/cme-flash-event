package com.cme.flasheventapi.dao;

import com.cme.flasheventapi.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {
    UserDetails findByUserName(String userName);
}
