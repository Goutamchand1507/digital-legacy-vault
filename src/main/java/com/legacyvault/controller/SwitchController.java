package com.legacyvault.controller;
import com.legacyvault.service.CurrentUserService; import com.legacyvault.repository.UserAccountRepository; import org.springframework.security.core.Authentication; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime;
@Controller public class SwitchController {
 private final CurrentUserService current;private final UserAccountRepository users;public SwitchController(CurrentUserService c,UserAccountRepository u){current=c;users=u;}
 @PostMapping("/check-in") public String checkIn(Authentication a){var u=current.require(a);u.setLastCheckIn(LocalDateTime.now());u.setReminderSentAt(null);users.save(u);return "redirect:/dashboard?checkedIn";}
 @GetMapping("/settings") public String settings(Authentication a,Model m){m.addAttribute("user",current.require(a));return "settings";}
 @PostMapping("/settings") public String save(@RequestParam int intervalDays,@RequestParam int gracePeriodHours,@RequestParam(defaultValue="false") boolean enabled,Authentication a,Model m){var u=current.require(a);if(intervalDays<1||intervalDays>365||gracePeriodHours<1||gracePeriodHours>720){m.addAttribute("user",u);m.addAttribute("error","Interval must be 1–365 days; grace period 1–720 hours.");return "settings";}u.setCheckInIntervalDays(intervalDays);u.setGracePeriodHours(gracePeriodHours);u.setSwitchEnabled(enabled);u.setLastCheckIn(LocalDateTime.now());u.setReminderSentAt(null);users.save(u);return "redirect:/settings?saved";}
}
