package org.sharpsw.sakura.auth;

public class Statement {
    public String getAction() {
        return "execute-api:Invoke";
    }

    public String getEffect() {
        return "allow";
    }

    public String getResource() {
        return "arn:aws:execute-api:us-east-1:970221509170:qjujy6ys88/*/GET/";
    }
}
