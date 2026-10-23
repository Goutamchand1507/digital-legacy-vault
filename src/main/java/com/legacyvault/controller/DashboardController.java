package com.legacyvault.controller;
import com.legacyvault.service.CurrentUserService; import com.legacyvault.repository.*; import org.springframework.security.core.Authentication; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.GetMapping;
@Controller public class DashboardController {
 private final CurrentUserService current; private final VaultItemRepository items; private final TrustedContactRepository contacts;
 public DashboardController(CurrentUserService c,VaultItemRepository i,TrustedContactRepository t){current=c;items=i;contacts=t;}
 @GetMapping("/dashboard") public String dashboard(Authentication a,Model m){var u=current.require(a);m.addAttribute("user",u);m.addAttribute("itemCount",items.countByOwner(u));m.addAttribute("contactCount",contacts.countByOwner(u));m.addAttribute("nextCheckIn",u.getLastCheckIn().plusDays(u.getCheckInIntervalDays()));m.addAttribute("overdue",java.time.LocalDateTime.now().isAfter(u.getLastCheckIn().plusDays(u.getCheckInIntervalDays())));return "dashboard";}
}
