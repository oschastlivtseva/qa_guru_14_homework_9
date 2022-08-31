package guru.qa.utils;

public enum Lang {
    RU("ru"),
    ES("es"),
    KO("ko"),
    NL("nl");

    String notation;

    Lang(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }
}
