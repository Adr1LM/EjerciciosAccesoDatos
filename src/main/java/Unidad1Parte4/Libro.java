package Unidad1Parte4;

public class Libro {

    private String titulo;
    private String autor;
    private int serie;

    public Libro(String titulo, String s) {
        this.titulo = titulo;
        this.autor = s;
    }

    public Libro() {
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
