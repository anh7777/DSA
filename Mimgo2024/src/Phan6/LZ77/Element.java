package Phan6.LZ77;

class Element {
    Occurrence o;
    int s;

    Element(Occurrence o, int s) {
        this.o = o;
        this.s = s;
    }

    @Override
    public String toString() {
        return o.toString() + s;
    }
}
