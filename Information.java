import java.util.ArrayList;
import java.util.List;
public class Information {
        private List<Film> films;

        public Information() {
            films = new ArrayList<>();
        }

        public void addFilm(Film film) {
            films.add(film);
        }

        public List<Film> getFilms() {
            return films;
        }
    }

