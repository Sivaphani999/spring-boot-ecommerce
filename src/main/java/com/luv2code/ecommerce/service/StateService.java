package com.luv2code.ecommerce.service;

import com.luv2code.ecommerce.dao.StateDao;
import com.luv2code.ecommerce.dto.StateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    StateDao stateDao;
    public List<StateDTO> getStates() {
        return stateDao.getStates();
    }

    public List<StateDTO> getStatesById(int id) {
        return stateDao.getStatesById(id);
    }

    public List<StateDTO> getStatesByCountryCode(String countryCode) {
        return stateDao.getStatesByCountryCode(countryCode);
    }
}
