package de.heckenmann;

public class BeispielEntity {

    private String feld1;

    private String feld2;

    public BeispielEntity() {}

    public BeispielEntity(final String feld1, final String feld2) {
        this.feld1 = feld1;
        this.feld2 = feld2;
    }

    public String getFeld1() {
        return this.feld1;
    }

    public void setFeld1(final String feld1) {
        this.feld1 = feld1;
    }

    public String getFeld2() {
        return this.feld2;
    }

    public void setFeld2(final String feld2) {
        this.feld2 = feld2;
    }

}
