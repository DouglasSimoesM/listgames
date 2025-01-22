package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repository.GameReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameReporitory gameReporitory;

    public List<GameMinDTO> findAll (){
        List<Game> result = gameReporitory.findAll();

        return result.stream().map(x -> new GameMinDTO(x)).toList();

    }
}