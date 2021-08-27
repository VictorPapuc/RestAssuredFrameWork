package com.student.endpoint;

public enum Path {

  List("/list");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
