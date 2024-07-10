package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.dto.StateDTO;
import com.luv2code.ecommerce.repository.StateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StateDao {

    @Autowired
    StateRepository stateRepository;

    @Autowired
    ModelMapper modelMapper;
    public List<StateDTO> getStates() {
        return stateRepository.findAll().stream().map(state -> modelMapper.map(state,StateDTO.class)).collect(Collectors.toList());
    }

    public List<StateDTO> getStatesById(int id) {
        return stateRepository.findByCountryId(id).stream().map(state -> modelMapper.map(state, StateDTO.class)).collect(Collectors.toList());
    }

    public List<StateDTO> getStatesByCountryCode(String countryCode) {
        return stateRepository.findByCountryCode(countryCode).stream().map(state -> modelMapper.map(state, StateDTO.class)).collect(Collectors.toList());
    }
}