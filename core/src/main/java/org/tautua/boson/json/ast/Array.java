package org.tautua.boson.json.ast;

public class Array extends SimpleNode {
    public Array(int id) {
        super(id);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

