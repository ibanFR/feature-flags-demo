import ie.etu.Main;
import io.flipt.api.FliptClient;
import io.flipt.api.evaluation.models.BooleanEvaluationResponse;
import io.flipt.api.evaluation.models.EvaluationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Main class test
 * <p>
 * Scenario list:
 * <p>
 * 1. should evaluate a boolean flag successfully without context : Release toggle / Work-In-Progress-Feature
 * 2. should evaluate a boolean flag successfully for given context : Permissions toggle / EtuUser-Only
 * 2. should fail when server is not up and running
 * 2. should evaluate a variant flag
 * 3. should

 */
@ExtendWith(MockitoExtension.class)
class MainTest {

    @Mock
    private FliptClient fliptClient;

    //system under test
    private Main main;

    @BeforeEach
    public void setup() {
        main = new Main(fliptClient);
    }

    @Test
    void evaluatesBooleanEvaluationResponseSuccessfully() {
        // Given
        Map<String, String> context = new HashMap<>();
        context.put("UserRole", "EtuUser");

        EvaluationRequest booleanEvaluationRequest = EvaluationRequest.builder()
                .namespaceKey("testbed")
                .flagKey("Work-In-Progress-Feature")
                .entityId("a381e194-9159-4fa0-9bfd-19a8c239c985")
                .context(context)
                .build();

        BooleanEvaluationResponse booleanEvaluationResponse = mock(BooleanEvaluationResponse.class);
        when(booleanEvaluationResponse.isEnabled()).thenReturn(true);
        when(fliptClient.evaluation().evaluateBoolean(booleanEvaluationRequest)).thenReturn(booleanEvaluationResponse);

        // When
        boolean result = main.evaluateBooleanEvaluationRequest("flagKey");

        // Then
        assertEquals(true, result);
        verify(fliptClient.evaluation(), times(1)).evaluateBoolean(booleanEvaluationRequest);
    }

    @Test
    public void evaluatesBooleanEvaluationResponseUnsuccessfully() {
        // Given
        Map<String, String> context = new HashMap<>();
        context.put("UserRole", "EtuUser");
        EvaluationRequest booleanEvaluationRequest = EvaluationRequest.builder()
                .namespaceKey("testbed")
                .flagKey("Work-In-Progress-Feature")
                .entityId("a381e194-9159-4fa0-9bfd-19a8c239c985")
                .context(context)
                .build();
        BooleanEvaluationResponse booleanEvaluationResponse = mock(BooleanEvaluationResponse.class);
        when(booleanEvaluationResponse.isEnabled()).thenReturn(false);
        when(fliptClient.evaluation().evaluateBoolean(booleanEvaluationRequest)).thenReturn(booleanEvaluationResponse);

        // When
        boolean result = main.evaluateBooleanEvaluationRequest("flagKey");

        // Then
        assertEquals(false, result);
        verify(fliptClient.evaluation(), times(1)).evaluateBoolean(booleanEvaluationRequest);
    }
}
