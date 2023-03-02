# room-schema-export-bazel
Exporting Room DB Schema with Bazel

```
$ bazel build //...
INFO: Analyzed 8 targets (1 packages loaded, 1016 targets configured).
INFO: Found 8 targets...
INFO: From KotlinKapt @//app:lib_kt { kt: 4, java: 0, srcjars: 0 } for darwin_arm64:
warning: /var/folders/71/0r_ylvb13vv2my1_676sx1gm0000gn/T/pwd8457682526446134028/_kotlinc/app-lib_kt_jvm/temp/stubs/app/AppDatabase.java:7: warning: Schema export directory is not provided to the annotation processor so we cannot export the schema. You can either provide `room.schemaLocation` annotation processor argument OR set exportSchema to false.
public abstract class AppDatabase extends androidx.room.RoomDatabase {
                ^
INFO: Elapsed time: 11.509s, Critical Path: 8.76s
INFO: 110 processes: 26 internal, 72 darwin-sandbox, 12 worker.
INFO: Build completed successfully, 110 total actions
```
