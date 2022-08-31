package guru.qa.utils;

public enum SubjectsTab {
    FLASHCARDS("Flashcard sets"),
    SOLUTIONS("Textbook solutions"),
    HELP("Homework help");

    String notation;

    SubjectsTab(String notation) {
        this.notation = notation;
    }

    public String getNotation() {
        return notation;
    }
}

