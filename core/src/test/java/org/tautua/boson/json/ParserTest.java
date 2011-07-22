package org.tautua.boson.json;

import org.junit.Test;
import org.tautua.boson.json.ast.Node;
import org.tautua.boson.json.parser.ParseException;
import org.tautua.boson.json.parser.Parser;

import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 * User: lruiz
 * Date: 7/21/11
 * Time: 1:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class ParserTest {

    @Test
    public void parse() throws ParseException {
        Reader r = new StringReader("{\"quantity\": 100, \"symbol\": \"USD\", \"description\":null, " +
                "\"price\": 9.99, \"available\":true, \"dimension\": [10,10]}");
        Parser p = new Parser(r);
        Node n = p.parse();
        assertNotNull(n);
    }
}
