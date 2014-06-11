package it.comparison;

public interface Amazon {
    public String findPrice(String isbn);

    void setSite(String s);

    String getSite();
}
