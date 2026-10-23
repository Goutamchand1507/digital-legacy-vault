package com.legacyvault.repository;
import com.legacyvault.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface VaultItemRepository extends JpaRepository<VaultItem,Long>{
 List<VaultItem> findByOwnerOrderByCreatedAtDesc(UserAccount owner);
 Optional<VaultItem> findByIdAndOwner(Long id,UserAccount owner);
 long countByOwner(UserAccount owner);
}
