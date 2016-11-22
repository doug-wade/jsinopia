# JSinopia

My running attempt to get Sinopia up and running on the jvm


# Set-up

`jsinopia` uses a bundled sinopia that has to be built locally before you can run ita

```sh
npm i -g noderify
git clone https://github.com/doug-wade/sinopia
cd sinopia
npm i
noderify index.js > /path/to/jsinopia/bundle.js
```


# TODO

1. The run command fails with
    ```sh
    Could not find io.dougwade.jsinopia.Main. Make sure you have it in your classpath
        at org.apache.tools.ant.taskdefs.ExecuteJava.execute(ExecuteJava.java:138)
        at org.apache.tools.ant.taskdefs.Java.run(Java.java:771)
        at org.apache.tools.ant.taskdefs.Java.executeJava(Java.java:221)
        at org.apache.tools.ant.taskdefs.Java.executeJava(Java.java:135)
        at org.apache.tools.ant.taskdefs.Java.execute(Java.java:108)
        at org.apache.tools.ant.UnknownElement.execute(UnknownElement.java:292)
        at sun.reflect.GeneratedMethodAccessor9.invoke(Unknown Source)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.apache.tools.ant.dispatch.DispatchUtils.execute(DispatchUtils.java:106)
        at org.apache.tools.ant.Task.perform(Task.java:348)
        at org.apache.tools.ant.Target.execute(Target.java:435)
        at org.apache.tools.ant.Target.performTasks(Target.java:456)
        at org.apache.tools.ant.Project.executeSortedTargets(Project.java:1393)
        at org.apache.tools.ant.Project.executeTarget(Project.java:1364)
        at org.apache.tools.ant.helper.DefaultExecutor.executeTargets(DefaultExecutor.java:41)
        at org.apache.tools.ant.Project.executeTargets(Project.java:1248)
        at org.apache.tools.ant.Main.runBuild(Main.java:851)
        at org.apache.tools.ant.Main.startAnt(Main.java:235)
        at org.apache.tools.ant.Main.start(Main.java:198)
        at org.apache.tools.ant.Main.main(Main.java:286)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at com.intellij.rt.ant.execution.AntMain2.main(AntMain2.java:30)
    ```
1. The run-jar command fails with
    ```sh
    Error: Could not find or load main class io.dougwade.jsinopia.Main
    ```
1. The sinopia web jar installation fails with
```sh
[ivy:retrieve] 		::::::::::::::::::::::::::::::::::::::::::::::
[ivy:retrieve] 		::          UNRESOLVED DEPENDENCIES         ::
[ivy:retrieve] 		::::::::::::::::::::::::::::::::::::::::::::::
[ivy:retrieve] 		:: org.webjars.npm#remarkable;1 >=1.4: not found
[ivy:retrieve] 		:: org.webjars.npm#sanitize-html;1 >=1.4: not found
[ivy:retrieve] 		:: org.webjars.npm#express;[5.0.0-0,6.0.0-0): not found
[ivy:retrieve] 		:: org.webjars.npm#es6-shim;[0.21,0.22): not found
[ivy:retrieve] 		::::::::::::::::::::::::::::::::::::::::::::::
[ivy:retrieve]
[ivy:retrieve] :: USE VERBOSE OR DEBUG MESSAGE LEVEL FOR MORE DETAILS

BUILD FAILED
/Users/dwade/foss/jsinopia/jsinopia.xml:207: impossible to resolve dependencies:
	resolve failed - see output for details
```