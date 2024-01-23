package com.example.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameListDTO;
import com.example.dslist.dto.GameMinDTO;
import com.example.dslist.entities.Game;
import com.example.dslist.entities.GameList;
import com.example.dslist.repositories.GameListRepository;
import com.example.dslist.repositories.GameRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	/**
	 * A notation @transactional serve para o banco entender que sera somente escrita,
	 * fazendo que seja mais rapido
	 * @param gameId
	 * @return
	 */	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
	List<GameList> result = gameListRepository.findAll();
	List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
	return dto;
	}
	

}
