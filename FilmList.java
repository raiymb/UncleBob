package com.ab;

import java.util.ArrayList;
import java.util.List;
public class FilmList {
    private List<Film> films;

    public FilmList() {
        films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public List<Film> getFilms() {
        return films;
    }
}
