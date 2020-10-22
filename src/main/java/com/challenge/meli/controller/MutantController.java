package com.challenge.meli.controller;


import com.challenge.meli.model.dto.MutantDTO;
import com.challenge.meli.model.dto.MutantStatsDTO;
import com.challenge.meli.service.impl.MutantService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @Autowired
    MutantService mutantService;

    @PostMapping(value = "mutant"  , consumes = "application/json")
    public ResponseEntity dna(@RequestBody MutantDTO mutantDTO){
        boolean retorno = mutantService.isMutant(mutantDTO.getDna());
        mutantService.saveRecord(retorno);
        HttpStatus httpStatus = retorno ? HttpStatus.OK : HttpStatus.FORBIDDEN;
        return new ResponseEntity(new JSONObject().put("Status", httpStatus.name()).toString(), httpStatus);
    }
    @GetMapping("stats")
    public MutantStatsDTO showStats(){
        return new MutantStatsDTO(mutantService.countHuman(),
                mutantService.countMutant(),
                mutantService.ratio());
    }

    }
}
