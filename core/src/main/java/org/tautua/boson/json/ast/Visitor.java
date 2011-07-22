package org.tautua.boson.json.ast;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 7/21/11
 * Time: 1:43 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Visitor {
    void visit(Literal node);
    void visit(Instance node);
    void visit(Member node);
    void visit(Array node);
}
