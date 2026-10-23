package com.legacyvault.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="trusted_contacts")
public class TrustedContact {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private UserAccount owner;
 @Column(nullable=false,length=100) private String name;
 @Column(nullable=false,length=190) private String email;
 private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public UserAccount getOwner(){return owner;} public void setOwner(UserAccount v){owner=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v==null?null:v.trim().toLowerCase();}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
