package dmr.main;

class Tuple<X,Y> {
    public X first;
    public Y second;

    Tuple(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return first.toString() + " - " + second.toString();
    }
}