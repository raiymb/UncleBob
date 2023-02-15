package com.ab;

import java.util.ArrayList;
import java.util.List;

public class GenreList {
    private List<FilmList> genres;

    public GenreList() {
        genres = new ArrayList<>();
    }
    public void addGenre(FilmList filmList) {
        genres.add(filmList);
    }
    public List<FilmList> getGenres() {
        return genres;
    }

}
