package com.moa.backend.Persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moa.backend.Class.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
