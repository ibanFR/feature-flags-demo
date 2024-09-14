package ie.etu;


import io.flipt.api.FliptClient;
import io.flipt.api.evaluation.models.BooleanEvaluationResponse;
import io.flipt.api.evaluation.models.EvaluationRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Main class to evaluate a boolean feature flag value
 */
public class Main {

    private final FliptClient client;


    public Main(FliptClient client) {
        this.client = client;
    }

    public static void main(String[] args) {

        FliptClient fliptClient = FliptClient.builder().build();

        Map<String, String> context = new HashMap<>();
        context.put("UserRole", "EtuUser");

        EvaluationRequest booleanEvaluationRequest =
                EvaluationRequest.builder()
                        .namespaceKey("testbed")
                        .flagKey("Work-In-Progress-Feature")
                        //.flagKey("EtuUser-Only")
                        .entityId("a381e194-9159-4fa0-9bfd-19a8c239c985")
                        .context(context)
                        .build();

        BooleanEvaluationResponse booleanEvaluationResponse =
                fliptClient.evaluation().evaluateBoolean(booleanEvaluationRequest);

        System.out.println("Boolean Evaluation Response: " + booleanEvaluationResponse.isEnabled());

    }

    public boolean evaluateBooleanEvaluationRequest(String flagKey) {
        return false;
    }
}