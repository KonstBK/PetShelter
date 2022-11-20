package org.example.enums;

public enum Extension {
    XML(".xml"),
    JSON(".json"),
    YAML(".yaml");

    private final String extension;

    Extension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
