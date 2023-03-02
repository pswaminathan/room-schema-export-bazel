load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

android_sdk_repository(
    name = "androidsdk",
    api_level = 31,
    build_tools_version = "33.0.2",
)

rules_kotlin_version = "1.7.1"
rules_kotlin_sha = "fd92a98bd8a8f0e1cdcb490b93f5acef1f1727ed992571232d33de42395ca9b3"
http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/releases/download/v%s/rules_kotlin_release.tgz" % rules_kotlin_version],
    sha256 = rules_kotlin_sha,
)

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl", "kotlin_repositories")
kotlin_repositories() # if you want the default. Otherwise see custom kotlinc distribution below

# load("@io_bazel_rules_kotlin//kotlin:core.bzl", "kt_register_toolchains")
# kt_register_toolchains()
register_toolchains("//:kotlin_toolchain")


RULES_JVM_EXTERNAL_TAG = "4.4.2"

http_archive(
    name = "rules_jvm_external",
    sha256 = "735602f50813eb2ea93ca3f5e43b1959bd80b213b836a07a62a29d757670b77b",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")
load("@//:deps.bzl", "kotlin_deps")
maven_artifacts = kotlin_deps() + [
    maven.artifact("junit", "junit", "4.13", testonly = True),
]


maven_install(
    artifacts = maven_artifacts,
    repositories = [
        "https://dl.google.com/dl/android/maven2/",
        "https://repo.maven.apache.org/maven2/",
        "https://plugins.gradle.org/m2/",
        "https://maven.pkg.jetbrains.space/public/p/compose/dev",
        "https://appboy.github.io/appboy-android-sdk/sdk",
    ]
)
