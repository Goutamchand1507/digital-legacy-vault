package com.legacyvault.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity @Table(name="users")
public class UserAccount {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true,length=190) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false,length=100) private String fullName;
 @Column(nullable=false) private int checkInIntervalDays=30;
 @Column(nullable=false) private int gracePeriodHours=48;
 private LocalDateTime lastCheckIn=LocalDateTime.now();
 private LocalDateTime reminderSentAt;
 @Column(nullable=false) private boolean switchEnabled=false;
 public Long getId(){return id;} public String getEmail(){return email;}
 public void setEmail(String v){email=v==null?null:v.trim().toLowerCase();}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getFullName(){return fullName;} public void setFullName(String v){fullName=v;}
 public int getCheckInIntervalDays(){return checkInIntervalDays;} public void setCheckInIntervalDays(int v){checkInIntervalDays=v;}
 public int getGracePeriodHours(){return gracePeriodHours;} public void setGracePeriodHours(int v){gracePeriodHours=v;}
 public LocalDateTime getLastCheckIn(){return lastCheckIn;} public void setLastCheckIn(LocalDateTime v){lastCheckIn=v;}
 public LocalDateTime getReminderSentAt(){return reminderSentAt;} public void setReminderSentAt(LocalDateTime v){reminderSentAt=v;}
 public boolean isSwitchEnabled(){return switchEnabled;} public void setSwitchEnabled(boolean v){switchEnabled=v;}
}
