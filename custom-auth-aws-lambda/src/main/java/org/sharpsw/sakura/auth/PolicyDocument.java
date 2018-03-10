package org.sharpsw.sakura.auth;

import java.util.ArrayList;
import java.util.List;

public class PolicyDocument {
    public String getVersion() {
        return "2012-10-17";
    }

    public List<Statement> getStatement() {
        List<Statement> statements = new ArrayList<>();
        statements.add(new Statement());
        return statements;
    }
}
