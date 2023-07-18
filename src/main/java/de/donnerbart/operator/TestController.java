package de.donnerbart.operator;

import de.donnerbart.operator.v1beta1.TestResource;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestController implements Reconciler<TestResource> {

    private static final @NotNull Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Override
    public @NotNull UpdateControl<TestResource> reconcile(
            final @NotNull TestResource resource,
            final @NotNull Context<TestResource> context) {
        LOG.info("Reconcile {}", resource.getMetadata().getName());
        return UpdateControl.noUpdate();
    }
}
