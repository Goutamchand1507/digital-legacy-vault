package com.legacyvault.service;
import com.legacyvault.repository.UserAccountRepository; import org.slf4j.Logger; import org.slf4j.LoggerFactory; import org.springframework.scheduling.annotation.Scheduled; import org.springframework.stereotype.Component; import java.time.LocalDateTime;
@Component public class SwitchScheduler {
 private static final Logger log=LoggerFactory.getLogger(SwitchScheduler.class);private final UserAccountRepository users;public SwitchScheduler(UserAccountRepository u){users=u;}
 @Scheduled(fixedDelay=60000) public void check(){LocalDateTime now=LocalDateTime.now();users.findAll().forEach(u->{if(u.isSwitchEnabled()&&u.getReminderSentAt()==null&&now.isAfter(u.getLastCheckIn().plusDays(u.getCheckInIntervalDays()))){u.setReminderSentAt(now);users.save(u);log.warn("DEMO: reminder due for {}. No email or automatic release is performed.",u.getEmail());}});}
}
