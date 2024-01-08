load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")


android_sdk_repository(
    name = "androidsdk",
    api_level = 31,
    build_tools_version = "33.0.2",
)


http_archive(
    name = "io_bazel_rules_kotlin",
    sha256 = "a630cda9fdb4f56cf2dc20a4bf873765c41cf00e9379e8d59cd07b24730f4fde",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v1.8.1/rules_kotlin_release.tgz"],
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories", "kotlinc_version", "ksp_version")

kotlin_repositories(
    compiler_release = kotlinc_version(
        release = "1.9.10",
        sha256 = "7d74863deecf8e0f28ea54c3735feab003d0eac67e8d3a791254b16889c20342",
    ),
    ksp_compiler_release = ksp_version(
        release = "1.9.10-1.0.13",
        sha256 = "5b0b1179e8af40877d9d5929ec0260afb104956eabf2f23bb5568cfd6c20b37b",
    )
)

register_toolchains("//:kotlin_toolchain")


RULES_JVM_EXTERNAL_TAG = "5.3"

http_archive(
    name = "rules_jvm_external",
    sha256 = "d31e369b854322ca5098ea12c69d7175ded971435e55c18dd9dd5f29cc5249ac",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/releases/download/%s/rules_jvm_external-%s.tar.gz" % (RULES_JVM_EXTERNAL_TAG, RULES_JVM_EXTERNAL_TAG),
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()



git_repository(
    name = "grab_bazel_common",
    commit = "6ca6dc088be47730351185eb369ec17e27838f64",
    remote = "https://github.com/grab/grab-bazel-common.git",
)

load("@grab_bazel_common//rules:repositories.bzl", grab_bazel_common_dependencies = "bazel_common_dependencies")

grab_bazel_common_dependencies()

load("@grab_bazel_common//rules:setup.bzl", grab_bazel_common_setup = "bazel_common_setup")

grab_bazel_common_setup(
    patched_android_tools = True, # Optionally use patched android_tools jars
    buildifier_version = "6.3.3",
)

load("@grab_bazel_common//rules:maven.bzl", grab_pin_bazel_common_dependencies = "pin_bazel_common_dependencies")

grab_pin_bazel_common_dependencies()

load("@grab_bazel_common//:workspace_defs.bzl", "GRAB_BAZEL_COMMON_ARTIFACTS")

load("@rules_jvm_external//:specs.bzl", "maven")
load("@//:deps.bzl", "kotlin_deps")

maven_artifacts = kotlin_deps() + GRAB_BAZEL_COMMON_ARTIFACTS

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = maven_artifacts,
    repositories = [
        "https://repo.maven.apache.org/maven2/",
        "https://dl.google.com/dl/android/maven2/",
        "https://plugins.gradle.org/m2/",
        "https://maven.pkg.jetbrains.space/public/p/compose/dev",
    ],
    maven_install_json = "@//:maven_install.json",
)

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()
