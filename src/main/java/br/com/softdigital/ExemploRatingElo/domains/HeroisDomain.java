package br.com.softdigital.ExemploRatingElo.domains;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("herois")
public class HeroisDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String name;
    private String publisher;
    private byte[] image;
    private Double rating;
}