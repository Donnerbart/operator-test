package de.donnerbart.operator.v1beta1;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Singular;
import io.fabric8.kubernetes.model.annotation.Version;
import org.jetbrains.annotations.NotNull;

@Group("donnerbart.de")
@Version("v1beta1")
@Kind("TestResource")
@Singular("test-resource")
@Plural("test-resources")
@ShortNames("tr")
public class TestResource extends CustomResource<TestSpec, TestStatus> implements Namespaced {

    public TestResource() {
        super();
    }

    @Override
    protected @NotNull TestSpec initSpec() {
        return new TestSpec();
    }

    @Override
    protected @NotNull TestStatus initStatus() {
        return new TestStatus();
    }
}
