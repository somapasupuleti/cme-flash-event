package com.cme.flasheventapi.dao;

import com.cme.flasheventapi.entity.UserAnswers;
import com.cme.flasheventapi.entity.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserAnswersRepository extends CrudRepository<UserAnswers, Long> {

    UserAnswers findBySubmitDayAndUserName(Integer currentDay, String userName);
}
