package org.tautua.boson.json.ast;


import java.util.Map;

public class Instance extends SimpleNode {
    private Map<String, Member> members;
    public Instance(int id) {
        super(id);
    }


}

