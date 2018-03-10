package org.sharpsw.sakura.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthResponse {
    private String principalId;
    private String version = "2012-10-17";
    private String resource;
    private String effect;

    public AuthResponse setPrincipalId(String value) {
        principalId = value;
        return this;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public AuthResponse setVersion(String version) {
        this.version = version;
        return this;
    }

    public AuthResponse setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public AuthResponse setEffect(String effect) {
        this.effect = effect;
        return this;
    }

    public Map<String, Object> getPolicyDocument() {
        Map<String, Object> serializablePolicy = new HashMap<>();
        serializablePolicy.put("Version", version);

        java.util.Map<String, Object>[] serializableStatementArray = new java.util.Map[1];

        Map<String, Object> serializableStatement = new HashMap<>();
        serializableStatement.put("Effect", effect);
        serializableStatement.put("Action", "execute-api:Invoke");
        serializableStatement.put("Resource", resource);
        serializableStatementArray[0] = serializableStatement;

        serializablePolicy.put("Statement", serializableStatementArray);
        return serializablePolicy;
    }
}
