package br.com.softdigital.ExemploRatingElo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softdigital.ExemploRatingElo.domains.HeroisDomain;
import br.com.softdigital.ExemploRatingElo.dto.HeroisVoteDto;
import br.com.softdigital.ExemploRatingElo.services.HeroisService;

@RestController
@RequestMapping("/")
public class HeroisResource {
    
    private HeroisService heroisService;

    @Autowired
    public HeroisResource(HeroisService heroisService) {
        this.heroisService = heroisService;
    }

    @GetMapping
    public ResponseEntity<List<HeroisDomain>> getTwoHeroisRandom() {
        return ResponseEntity.ok().body(heroisService.getTwoHeroisRandom());
    }

    @PutMapping
    public ResponseEntity voteHerois(@RequestBody HeroisVoteDto objDto) {
        heroisService.voteHerois(objDto);
        return ResponseEntity.ok().build();
    }
}