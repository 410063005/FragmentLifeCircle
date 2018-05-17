
# Arch

[Arch](https://developer.android.com/topic/libraries/architecture/adding-components)



# Room
[Room简介](https://developer.android.com/topic/libraries/architecture/room#db-migration-testing)

Room是SQLite之上一个抽象层，保留SQLite完整功能的同时提供了便捷的访问方式。

这个库帮助建立应用缓存。该绊缓存用作应用的单一数据来源。 This cache, which serves as your app's single source of truth, allows users to view a consistent copy of key information within your app, regardless of whether users have an internet connection.

[Room用法](https://developer.android.com/training/data-storage/room/)

在本地持久化数据，可以让处理数据量较多的应用极大地受益。最常见的使用场景是缓存相关的数据。这样的话，即使没有网络用户也可以看到应用内容。有网络的情况下，用户可以主动更新应用数据。

非常建议使用Room替代SQLite。添加如下依赖，参考自[arch](https://developer.android.com/topic/libraries/architecture/adding-components#room)：

```groovy
dependencies {
    def room_version = "1.1.0"

    implementation "android.arch.persistence.room:runtime:$room_version"
    annotationProcessor "android.arch.persistence.room:compiler:$room_version"

    // optional - RxJava support for Room
    implementation "android.arch.persistence.room:rxjava2:$room_version"

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation "android.arch.persistence.room:guava:$room_version"

    // Test helpers
    testImplementation "android.arch.persistence.room:testing:$room_version"
}
```

Room的主要组件

+ Database
+ Entity
+ DAO

![](screenshots/room_architecture.png)


[Room实例](https://developer.android.com/training/data-storage/room/)

[Room RxJava支持](https://medium.com/google-developers/room-rxjava-acb0cd4f3757)


https://developer.android.com/training/data-storage/room/
https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0
https://github.com/googlesamples/android-architecture-components/tree/master/BasicSample

https://medium.com/@BladeCoder/kotlin-singletons-with-argument-194ef06edd9e


这是一个来自https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#2的示例


#