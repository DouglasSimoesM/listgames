package com.devsuperior.dslist.repository;


import com.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListReporitory extends JpaRepository<GameList, Long> {


}
