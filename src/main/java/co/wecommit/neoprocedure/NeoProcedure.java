package co.wecommit.neoprocedure;

import java.util.stream.*;
import org.neo4j.graphdb.*;
import org.neo4j.procedure.*;

import org.neo4j.procedure.Mode;

public class NeoProcedure {

    @Context
    public GraphDatabaseService db;

    public static class SomethingResult {
        public String output;

        public SomethingResult(String output) {
            this.output = output;
        }
    }

    @Procedure(value = "wecommit.dosomething", mode= Mode.WRITE)
    @Description("Do something")
    public Stream<SomethingResult> dosomething(@Name("input") String input) {
        return Stream.of(new SomethingResult(input));
    }

    @UserFunction
    @Description("co.wecommit.neoprocedure.somethingelse - do something else")
    public String somethingelse(@Name("input") String input) {
        return input;
    }
}