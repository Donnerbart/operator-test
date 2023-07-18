package de.donnerbart.operator.v1beta1;

import org.jetbrains.annotations.NotNull;

public class TestSpec {

    private @NotNull String customField;

    public TestSpec() {
    }

    public @NotNull String getCustomField() {
        return customField;
    }

    public void setCustomField(final @NotNull String customField) {
        this.customField = customField;
    }
}
