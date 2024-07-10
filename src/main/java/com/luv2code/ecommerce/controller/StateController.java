package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.CommonUtil.ResponseResource;
import com.luv2code.ecommerce.dto.StateDTO;
import com.luv2code.ecommerce.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping("")
    public ResponseEntity<ResponseResource<List<StateDTO>>> getStates(){
        try{
            List<StateDTO> stateDTOList = stateService.getStates();
            ResponseResource<List<StateDTO>> resource = new ResponseResource<>(stateDTOList);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(),ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResource<List<StateDTO>>> getStates(@PathVariable("id") int id){
        try{
            List<StateDTO> stateDTOList = stateService.getStatesById(id);
            ResponseResource<List<StateDTO>> resource = new ResponseResource<>(stateDTOList);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(),ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }

    @GetMapping("/search/findByCountryCode")
    public ResponseEntity<ResponseResource<List<StateDTO>>> getStatesByCountryCode(@RequestParam("code") String countryCode){
        try{
            List<StateDTO> stateDTOList = stateService.getStatesByCountryCode(countryCode);
            ResponseResource resource = new ResponseResource<>(stateDTOList);
            return ResponseEntity.ok(resource);
        } catch (Exception e){
            ResponseResource resource = new ResponseResource<>(e.getMessage(),ResponseResource.R_CODE_ERROR);
            return ResponseEntity.ok(resource);
        }
    }
}
