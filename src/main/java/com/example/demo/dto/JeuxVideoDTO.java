package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class JeuxVideoDTO {

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String editeur;

    @Getter
    @Setter
    private String anneSortie;

    @Getter
    @Setter
    private List<ConsoleDTO> consoles = new ArrayList<>();

    @Override
    public String toString() {

        String res = jeuxVideoToJson();

        return res;
    }

    /**
     * Transforme le contenu de l'objet sous forme de Json
     * @return String au format Json
     */
    public String jeuxVideoToJson() {
        String res = "{\"nom\": \"" + this.getNom() + "\"";
        res += ", \"editeur\": \"" + this.getEditeur() + "\"";
        res += ", \"anneSortie\": \"" + this.getAnneSortie() + "\"";

        res += (this.getConsoles().size() > 0 ) ? ", \"consoles\": [" : "" ;

        res += this.getConsoles().stream()
                .map(x -> {
                    String resConsole = "{";
                    resConsole += " \"nom\" : \"" + x.getNom() + "\"";
                    resConsole += ", \"marque\" : \"" + x.getMarque() + "\"";
                    resConsole += "}";
                    return resConsole;
                }).collect(Collectors.joining(","));

        // Ceci est un if
        res += (this.getConsoles().size() > 0 ) ? "]" : "" ;
        res += "}";
        return res;
    }

    /**
     * Retourne le contenu de l'objet en explicitant les champs
     * @return String
     */
    public String jeuxVideoDetails() {
        String resLog = "\nNom du jeux : " + this.getNom();
        resLog += "\nEditeur : " + this.getEditeur();
        resLog += "\nAnnée de sortie : " + this.getAnneSortie();

        String plurielLog = (this.getConsoles().size() > 1 ) ? "les consoles : " : "la console : " ;

        resLog += "\nSortie sur " + plurielLog;

        StringBuilder stringBuilderLog = new StringBuilder();
        this.getConsoles().stream()
                .map(x -> {
                    String resConsole = "\n    Nom : " + x.getNom();
                    resConsole += "\n    Compagnie : " + x.getMarque();
                   return resConsole;
                }).forEach(stringBuilderLog::append);

        resLog += stringBuilderLog;
        return resLog;
    }
}
