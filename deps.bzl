load("@rules_jvm_external//:specs.bzl", "maven")

def kotlin_deps():
    version = "2.6.0"
    libraries = [
        "common",
        "compiler",
        "ktx",
        "migration",
        "runtime",
        "testing",
    ]
    return [
        "androidx.room:room-%s:%s" % (lib, version)
        for lib in libraries
    ] + [
        maven.artifact("androidx.room", "room-testing", version, testonly = True),
    ]
