BufferKnife 配置：
1、在project的build.gradle里的dependencies 作如下配置：
    classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'

2、在app的build.gradle里的最上面作如下配置：
    apply plugin: 'com.android.application'
    apply plugin: 'com.neenbedankt.android-apt'

3、在app的build.gradle里的dependencies 作如下配置：
    compile 'com.jakewharton:butterknife:8.8.1'
    apt 'com.jakewharton:butterknife-compiler:8.8.1'

BufferKnife Zelezny插件：
AndroidStudio->File->Settings->Plugins->搜索Zelezny下载添加