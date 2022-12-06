package com.kurenkievtimur.cw9.repository;

import com.kurenkievtimur.cw9.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
