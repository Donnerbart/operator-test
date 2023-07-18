package de.donnerbart.operator;

import io.javaoperatorsdk.operator.Operator;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kubernetes.client.KubernetesServerTestResource;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@QuarkusTestResource(KubernetesServerTestResource.class)
class TestControllerTest {

    private static final @NotNull Logger LOG = LoggerFactory.getLogger(TestControllerTest.class);

    @Inject
    protected @NotNull Operator operator;

    @BeforeEach
    void setUp() {
        operator.start();
        assertThat(operator.getRuntimeInfo().isStarted()).isTrue();
    }

    @AfterEach
    void tearDown() {
        operator.stop();
    }

    @Test
    @Timeout(60)
    void reconcile() {
        final var client = operator.getKubernetesClient();
        assertThat(client).isNotNull();

        LOG.info("Test is running in namespace '{}'", client.getNamespace());
    }
}
