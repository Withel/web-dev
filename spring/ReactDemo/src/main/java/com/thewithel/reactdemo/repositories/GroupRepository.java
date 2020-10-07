package com.thewithel.reactdemo.repositories;

import com.thewithel.reactdemo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
