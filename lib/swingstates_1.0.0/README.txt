SwingStates, Version 1.0.0

Copyright (c) Université Paris-Sud XI, 2007.

swingstates-1.0.0.jar (in "lib" directory) contains all binary and source files to write a Java program using SwingStates. Just add swingstates-1.0.0.jar to your Java classpath.

SwingStates is a Maven project,
1/ Declare your dependency to SwingStates in your project's pom.xml:
<dependencies>
  <dependency>
    <groupId>fr.lri.swingstates</groupId>
    <artifactId>swingstates</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
2/ Make it available in your local maven repository:
- by using the "mvn install" command in the swingstates root folder, or
- by adding the "ilda-repository" maven repository in your project's pom.xml:
<repositories>
  <repository>
    <id>ilda-repository</id>
    <url>http://ilda.saclay.inria.fr/maven</url>
  </repository>
</repositories>

SwingStates tutorial (http://swingstates.sourceforge.net/tutorial/index.html) presents a set of applet examples to help you start with SwingStates. The source code for these applets is located in fr.lri.swingstates.applets.
