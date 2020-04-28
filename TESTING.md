# Testing with java modules

## Module path
```
--module-path
    C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\classes\java\test;
    C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\resources\test;
    C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\classes\java\main;
    C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\resources\main;
    C:\Users\frst\Documents\dev\java-modules\user-service\build\libs\user-service.jar;
    C:\Users\frst\Documents\dev\java-modules\user-domain\build\libs\user-domain.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-launcher\1.6.2\d866de2950859ca1c7996351d7b3d97428083cd0\junit-platform-launcher-1.6.2.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-engine\1.6.2\1752cad2579e20c2b224602fe846fc660fb35805\junit-platform-engine-1.6.2.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.junit.platform\junit-platform-commons\1.6.2\7644a14b329e76b5fe487628b50fb5eab6ba7d26\junit-platform-commons-1.6.2.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-engine\5.6.2\c0833bd6de29dd77f8d071025b97b8b434308cd3\junit-jupiter-engine-5.6.2.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.junit.jupiter\junit-jupiter-api\5.6.2\c9ba885abfe975cda123bf6f8f0a69a1b46956d0\junit-jupiter-api-5.6.2.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.apiguardian\apiguardian-api\1.1.0\fc9dff4bb36d627bdc553de77e1f17efd790876c\apiguardian-api-1.1.0.jar;
    C:\Users\frst\.gradle\caches\modules-2\files-2.1\org.opentest4j\opentest4j\1.2.0\28c11eb91f9b6d8e200631d46e20a7f407f2a046\opentest4j-1.2.0.jar 
```

## Command line options

### Patch module
```
--patch-module
    providers.user=
        C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\classes\java\test;
        C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\resources\main;
        C:\Users\frst\Documents\dev\java-modules\user-service-provider-1\build\resources\test
```

### Add module
```
--add-modules
    ALL-MODULE-PATH
```

### Requires
```
--add-reads
    providers.user=org.junit.jupiter.api
```

### Reflection
```
--add-opens 
    providers.user/ch.resrc.providers.user=org.junit.platform.commons
```
