load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

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

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below

# load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
# kt_register_toolchains()
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


load("@rules_jvm_external//:specs.bzl", "maven")
load("@//:deps.bzl", "kotlin_deps")

maven_artifacts = kotlin_deps() + [
    maven.artifact("junit", "junit", "4.13", testonly = True),
]

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
