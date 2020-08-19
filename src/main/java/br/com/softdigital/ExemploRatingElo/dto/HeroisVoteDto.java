package br.com.softdigital.ExemploRatingElo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HeroisVoteDto {
    private String idHeroiWinner;
    private String idHeroiLoser;
}