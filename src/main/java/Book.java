public class Book {

    private String name;
    private int rok;
    private long numer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public long getNumer() {
        return numer;
    }

    public void setNumer(long numer) {
        this.numer = numer;
    }

    @Override
    public String toString() {
        return "\n Tytuł: " + name +
                "\n Rok: " + rok +
                ", Numer: " + numer;
    }
}
