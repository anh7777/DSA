package Phan6.LZ77;

class Occurrence {
    int retour;
    int size;

    Occurrence (int retour, int size) {
        this.retour = retour;
        this.size = size;
    }

    @Override
    public String toString() {
        return "(" + retour + "," + size + ")";
    }
}
