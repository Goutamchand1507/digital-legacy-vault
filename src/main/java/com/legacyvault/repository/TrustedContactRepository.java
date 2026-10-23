package com.legacyvault.repository;
import com.legacyvault.entity.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface TrustedContactRepository extends JpaRepository<TrustedContact,Long>{
 List<TrustedContact> findByOwnerOrderByCreatedAtDesc(UserAccount owner);
 Optional<TrustedContact> findByIdAndOwner(Long id,UserAccount owner);
 long countByOwner(UserAccount owner);
}
