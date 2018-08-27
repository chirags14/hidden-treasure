package com.treasure.group.hiddentreasure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treasure.group.hiddentreasure.entity.Players;

@Repository
public interface HiddenTreasurePlayersRepository extends JpaRepository<Players, String>{

}
