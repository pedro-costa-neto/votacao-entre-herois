package br.com.softdigital.ExemploRatingElo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.softdigital.ExemploRatingElo.domains.HeroisDomain;
import br.com.softdigital.ExemploRatingElo.dto.HeroisVoteDto;
import br.com.softdigital.ExemploRatingElo.repositories.HeroisRepository;
import br.com.softdigital.ExemploRatingElo.services.helps.CalculateRatingElo;

@Service
public class HeroisService {
    
    private HeroisRepository heroisRepository;

    @Autowired
    public HeroisService(HeroisRepository heroisRepository) {
        this.heroisRepository = heroisRepository;
    }
    
    public List<HeroisDomain> findAll() {
        return heroisRepository.findAll();
    }

    public HeroisDomain findById(String id) {
        return heroisRepository.findById(id).get();
    }

    public HeroisDomain findRandom() {
        return heroisRepository.findRandom();
    }

    public List<HeroisDomain> getTwoHeroisRandom() {
        List<HeroisDomain> listAll = findAll();
        List<HeroisDomain> list = new ArrayList<>();
        Random random = new Random();
        int control = 0;

        while(control < 2) {
            int value = random.nextInt(listAll.size());
            list.add(listAll.get(value));
            control++;
        }

        return list;
    }

    public void voteHerois(HeroisVoteDto objDto) {
        HeroisDomain heroiWinner = findById(objDto.getIdHeroiWinner());
        HeroisDomain heroiLoser  = findById(objDto.getIdHeroiLoser());

        Double ratingA = heroiWinner.getRating() != null ? heroiWinner.getRating() : 0;
        Double ratingB = heroiLoser.getRating() != null ? heroiLoser.getRating() : 0;

        CalculateRatingElo calc = new CalculateRatingElo(10, ratingA, ratingB, 1, 0);
        heroiWinner.setRating(calc.getRatingA());
        heroiLoser.setRating(calc.getRatingB());

        System.out.println("RatingA: " + calc.getRatingA());
        System.out.println("RatingB: " + calc.getRatingB());

        heroisRepository.save(heroiWinner);
        heroisRepository.save(heroiLoser);
    }
}