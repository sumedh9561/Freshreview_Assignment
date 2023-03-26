package com.freshview.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freshview.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
   
    
}
