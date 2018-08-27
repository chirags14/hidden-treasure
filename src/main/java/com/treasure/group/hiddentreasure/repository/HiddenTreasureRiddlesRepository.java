package com.treasure.group.hiddentreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treasure.group.hiddentreasure.entity.Riddles;

@Repository
public interface HiddenTreasureRiddlesRepository extends JpaRepository<Riddles, Long>{

}
