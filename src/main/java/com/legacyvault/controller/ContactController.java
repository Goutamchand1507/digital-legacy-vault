package com.legacyvault.controller;
import com.legacyvault.entity.TrustedContact; import com.legacyvault.repository.TrustedContactRepository; import com.legacyvault.service.CurrentUserService; import org.springframework.security.core.Authentication; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller public class ContactController {
 private final TrustedContactRepository contacts;private final CurrentUserService current;public ContactController(TrustedContactRepository c,CurrentUserService u){contacts=c;current=u;}
 @GetMapping("/contacts") public String list(Authentication a,Model m){m.addAttribute("contacts",contacts.findByOwnerOrderByCreatedAtDesc(current.require(a)));return "contacts";}
 @PostMapping("/contacts") public String add(@RequestParam String name,@RequestParam String email,Authentication a,Model m){if(name.isBlank()||!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")){m.addAttribute("error","Enter a name and valid email.");m.addAttribute("contacts",contacts.findByOwnerOrderByCreatedAtDesc(current.require(a)));return "contacts";}TrustedContact c=new TrustedContact();c.setOwner(current.require(a));c.setName(name.trim());c.setEmail(email);contacts.save(c);return "redirect:/contacts?added";}
 @PostMapping("/contacts/{id}/delete") public String delete(@PathVariable Long id,Authentication a){contacts.findByIdAndOwner(id,current.require(a)).ifPresent(contacts::delete);return "redirect:/contacts?deleted";}
}
