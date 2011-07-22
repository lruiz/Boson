package org.tautua.boson.json.ast;


public class Literal extends SimpleNode {
    protected Object value;

    public Literal(int id) {
        super(id);
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Literal literal = (Literal) o;

        if (value != null ? !value.equals(literal.value) : literal.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "<<" + value + ">>";
    }
}
