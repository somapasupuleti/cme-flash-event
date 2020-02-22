package com.cme.flasheventapi.ctrl;

import com.cme.flasheventapi.dao.UserAnswersRepository;
import com.cme.flasheventapi.dao.UserDetailsRepository;
import com.cme.flasheventapi.entity.UserAnswers;
import com.cme.flasheventapi.entity.UserDetails;
import com.cme.flasheventapi.model.UserAnswersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("flashevent")
@CrossOrigin
public class FlashEventCtrl {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserAnswersRepository userAnswersRepository;

    @RequestMapping(value = "validateuser/{userId}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> validateUser(@PathVariable String userId) {
        try {
            UserDetails user = userDetailsRepository.findByUserName(userId);
            if (user != null) {
                LocalDate currentDate = LocalDate.now();
                int currentDay = currentDate.getDayOfMonth();
                UserAnswers userAnswers = userAnswersRepository.findBySubmitDayAndUserName(currentDay, userId);
                if (userAnswers != null) {
                    return new ResponseEntity<>("User already submitted answers for today", HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("Valid User", HttpStatus.OK);
                }
            } else {
                return new ResponseEntity<>("Not a Valid User", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Not a Valid User", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "answers/{userId}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> submitAnswers(@PathVariable String userId, @RequestBody UserAnswersVO userAnswersVO) {
        try {
            LocalDate currentDate = LocalDate.now();
            int currentDay = currentDate.getDayOfMonth();

            UserAnswers userAnswers = new UserAnswers();
            userAnswers.setUserName(userId);
            userAnswers.setSubmitDay(currentDay);
            userAnswers.setAnswerOne(userAnswersVO.getAnswer1());
            userAnswers.setAnswerTwo(userAnswersVO.getAnswer2());
            userAnswers.setAnswerThree(userAnswersVO.getAnswer3());

            userAnswersRepository.save(userAnswers);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Unable to update user", HttpStatus.OK);
        }
    }
}
