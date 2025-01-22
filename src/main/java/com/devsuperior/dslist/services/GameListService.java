package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repository.GameListReporitory;
import com.devsuperior.dslist.repository.GameReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListReporitory gameListReporitory;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GameListDTO> findAll (){
        List<GameList> result = gameListReporitory.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}