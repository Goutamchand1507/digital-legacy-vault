package com.legacyvault.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="vault_items")
public class VaultItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="user_id") private UserAccount owner;
 @Column(nullable=false,length=150) private String title;
 @Column(nullable=false,length=80) private String category;
 @Column(nullable=false,columnDefinition="TEXT") private String content;
 @Column(nullable=false) private boolean releaseAuthorized=false;
 @Column(nullable=false) private LocalDateTime createdAt=LocalDateTime.now();
 public Long getId(){return id;} public UserAccount getOwner(){return owner;} public void setOwner(UserAccount v){owner=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public String getContent(){return content;} public void setContent(String v){content=v;}
 public boolean isReleaseAuthorized(){return releaseAuthorized;} public void setReleaseAuthorized(boolean v){releaseAuthorized=v;}
 public LocalDateTime getCreatedAt(){return createdAt;}
}
