package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repository.GameReporitory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameReporitory gameReporitory;

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameReporitory.findById(id).get();
        return new GameDTO(result);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GameMinDTO> findAll (){
        List<Game> result = gameReporitory.findAll();

        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<GameMinDTO> findByList (Long listId){
        List<GameMinProjection> result = gameReporitory.searchByList(listId);

        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }


}