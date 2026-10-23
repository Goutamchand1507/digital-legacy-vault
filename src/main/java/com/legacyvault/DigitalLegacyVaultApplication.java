
package com.legacyvault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DigitalLegacyVaultApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalLegacyVaultApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showWebsiteLink() {
        System.out.println();
        System.out.println("========================================");
        System.out.println(" Digital Legacy Vault is running!");
        System.out.println(" Website: http://localhost:8080/login");
        System.out.println("========================================");
        System.out.println();
    }
}
