package com.legacyvault.controller;
import com.legacyvault.entity.VaultItem; import com.legacyvault.repository.VaultItemRepository; import com.legacyvault.service.CurrentUserService; import org.springframework.security.core.Authentication; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.*;
@Controller public class VaultController {
 private final VaultItemRepository items;private final CurrentUserService current;public VaultController(VaultItemRepository i,CurrentUserService c){items=i;current=c;}
 @GetMapping("/vault") public String list(Authentication a,Model m){m.addAttribute("items",items.findByOwnerOrderByCreatedAtDesc(current.require(a)));return "vault";}
 @PostMapping("/vault") public String add(@RequestParam String title,@RequestParam(defaultValue="Personal note") String category,@RequestParam String content,@RequestParam(defaultValue="false") boolean releaseAuthorized,Authentication a,Model m){
  if(title.isBlank()||content.isBlank()){m.addAttribute("error","Title and content are required.");m.addAttribute("items",items.findByOwnerOrderByCreatedAtDesc(current.require(a)));return "vault";}
  VaultItem i=new VaultItem();i.setOwner(current.require(a));i.setTitle(title.trim());i.setCategory(category);i.setContent(content.trim());i.setReleaseAuthorized(releaseAuthorized);items.save(i);return "redirect:/vault?added";
 }
 @PostMapping("/vault/{id}/delete") public String delete(@PathVariable Long id,Authentication a){items.findByIdAndOwner(id,current.require(a)).ifPresent(items::delete);return "redirect:/vault?deleted";}
}
