
# 1. Analyze dependencies

* Set working directory to
* Find out which is the bottom module -> use `jdeps build/libs/*.jar` on `user-service-consumer`

---

# 1. Modularize user domain module

* Find out which is the bottom module -> use `jdeps build/libs/*.jar` on `user-service-consumer`
* Add `module-info.java` to [java folder](user-domain/src/main/java) of `user-domain` module
* Set working directory to [user-domain module](user-domain) and execute `jdeps -s build/libs/*.jar` to see the resulting dependencies

---

# 4. Execute bottom up migration: Modularize user service module

* Add `module-info.java` to [java folder](user-service/src/main/java) of `user-service` module
* Copy `user-domain.jar` to [libs folder](user-service/build/libs) of `user-service` module
* Set working directory to [user-service module](user-service) and execute `jdeps -s build/libs/*.jar` to see the resulting dependencies
                                                                   
---

# 5. Execute bottom up migration: Modularize user service provider one

* Assume we do not yet know the `ch.resrc.consumers.user` package is defined in more than one module
* Add `module-info.java` to [java folder](user-service-provider-1/src/main/java) of `user-service-provider-1` module
* Set working directory to [user-service-provider-1 module](user-service-provider-1) and execute `jdeps -s build/libs/*.jar` to see the resulting dependencies

---

# 6. Execute bottom up migration: Modularize user service provider two

* Add `module-info.java` to [java folder](user-service-provider-2/src/main/java) of `user-service-provider-2` module
* Set working directory to [user-service-provider-2 module](user-service-provider-2) and execute `jdeps -s build/libs/*.jar` to see the resulting dependencies

---

# 7. Execute bottom up migration: Modularize user service consumer

* Add `module-info.java` to [java folder](user-service-consumer/src/main/java) of `user-service-consumer` module
* Now the compile complains about reading package `ch.resrc.consumer.user` from both `user-service-provider-1` and `user-service-provider-2`
* Fix split package by removing `user-service-provider-2` and renaming `user-service-provider-1` to `user-service-provider`
* Execute `installDist`
* Create dot files to visualize dependencies by executing: `jdeps -dotoutput build/graphs build/install/application/lib/*.jar`
* Set working directory to [user-service-consumer module](user-service-consumer) and execute `jdeps -s build/libs/*.jar` to see the resulting dependencies

---

# 8. Create an executable with jlink

---

# Appendix

---

# Resources

---

# Commands

The follwoing commands assume the working directory to be `module-examples/basic-example/application`

# Execute the application JAR via java command

`java -p build/install/application/lib -m application/ch.resrc.application.Application`

# Create an executable for the application

To create an executable for the application execute: `jlink --module-path $JAVA_HOME/jmods:build/install/application/lib --add-modules application --launcher application=application/ch.resrc.application.Application --output build/application --compress=2`

# Execute the executable of the application

This command executes the executable created via jlink: `build/install/application/bin/application`

# Compare size of JDK to size of executable

Display size of JDK: `du -h $JAVA_HOME`
Display size of executable: ` du -h build/application`

# List dependencies of modules (resp. JAR files) with jdeps

To analyze the dependencies of the modules execute: `jdeps build/install/application/lib/*.jar`
To get a summary of the dependencies execute: `jdeps -s build/install/application/lib/*.jar`

# Create dot files to visualize dependencies

`jdeps -dotoutput build/graphs build/install/application/lib/*.jar`

# Create PNG files for the dot files

You need to install graphviz for this to work (`brew install graphviz`)

To create a png file for the dependency summary execute: `dot -Tpng -Gdpi=300 build/graphs/summary.dot > build/graphs/summary.png`
For the application module execute: `dot -Tpng -Gdpi=300 build/graphs/application.jar.dot > build/graphs/application.png`
For the service module execute: `dot -Tpng -Gdpi=300 build/graphs/services.jar.dot > build/graphs/services.png`