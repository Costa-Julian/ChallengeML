package com.challenge.meli.controller;



import com.challenge.meli.returns.MutantStats;
import com.challenge.meli.model.*;
import com.challenge.meli.repository.MutantRepository;
import com.challenge.meli.service.ClassMethodsService;
import com.challenge.meli.service.VectoresService;
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
    MutantRepository repo;
    @Autowired
    ClassMethodsService classMethodsService;



    @PostMapping(value = "mutant"  , consumes = "application/json")
    public ResponseEntity<Object> dna(@RequestBody MutantEntity dna){

        boolean retorno = classMethodsService.isMutant(dna,
                VectoresService.getVectorA(),
                VectoresService.getVectorC(),
                VectoresService.getVectorG());
        classMethodsService.saveRecord(retorno);
        if (retorno==true){
            return ResponseEntity.ok("{\"Status\" : \"200 ok\"}");
        }else
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("{\"Status\" : \"403-Forbidden\"}");
    }
    @GetMapping("stats")
    public MutantStats showStats(){
        return new MutantStats(repo.findByHuman(),
                repo.findByMutant(),
                classMethodsService.ratio());
    }
}
