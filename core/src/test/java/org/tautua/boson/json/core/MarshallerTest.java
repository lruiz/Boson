package org.tautua.boson.json.core;

import junit.framework.TestCase;
import org.tautua.foo.Person;
import org.tautua.foo.Task;
import org.tautua.foo.TaskImpl;
import org.tautua.boson.json.Context;
import org.tautua.boson.json.ContextFactory;
import org.tautua.boson.json.Marshaller;
import org.tautua.boson.json.MarshallerFactory;
import org.tautua.boson.json.core.fetching.FetchPlanImpl;
import org.tautua.boson.json.core.fetching.FieldNameRule;
import org.tautua.boson.json.core.fetching.MaxDepthRule;

import java.io.StringWriter;

public class MarshallerTest extends TestCase {

    public void testMarshalDefaultFetchPlan(){
        ContextFactory ctxf = new ContextFactoryImpl();
        Context ctx = ctxf.create();
        MarshallerFactory mf = new MarshallerFactoryImpl();
        Marshaller<Person> m = mf.create(Person.class);
        
        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Doe");
        p.setCurrentTask(new TaskImpl("abc",10));
        p.addRole("ADMIN");
        p.setTasksQueue(new Task[]{new TaskImpl("a21", 50)});

        StringWriter w = new StringWriter();
        m.marshal(p, w, ctx);
        System.out.println(w.toString());
    }

    public void testMarshalMaxDepth1(){
        FetchPlanImpl fp = new FetchPlanImpl();
        fp.addRule(new MaxDepthRule(1));

        ContextFactoryImpl ctxf = new ContextFactoryImpl();
        ctxf.setFetchPlan(fp);
        Context ctx = ctxf.create();
        MarshallerFactory mf = new MarshallerFactoryImpl();
        Marshaller<Person> m = mf.create(Person.class);

        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Doe");
        p.setCurrentTask(new TaskImpl("abc",10));
        p.addRole("ADMIN");
        p.setTasksQueue(new Task[]{new TaskImpl("a21", 50)});

        StringWriter w = new StringWriter();
        m.marshal(p, w, ctx);
        System.out.println(w.toString());
    }

    public void testMarshalMaxDepth3AndExclude(){
        FetchPlanImpl fp = new FetchPlanImpl();
        fp.addRule(new MaxDepthRule(3));
        fp.addRule(new FieldNameRule("roles", false));
        fp.addRule(new FieldNameRule("age", false));
        fp.addRule(new FieldNameRule("status", false));

        ContextFactoryImpl ctxf = new ContextFactoryImpl();
        ctxf.setFetchPlan(fp);
        Context ctx = ctxf.create();
        MarshallerFactory mf = new MarshallerFactoryImpl();
        Marshaller<Person> m = mf.create(Person.class);

        Person p = new Person();
        p.setFirstName("John");
        p.setLastName("Doe");
        p.setCurrentTask(new TaskImpl("abc",10));
        p.addRole("ADMIN");
        p.setTasksQueue(new Task[]{new TaskImpl("a21", 50)});

        StringWriter w = new StringWriter();
        m.marshal(p, w, ctx);
        System.out.println(w.toString());
    }
}
