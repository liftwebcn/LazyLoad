//Nombre del proyecto
name := "Lazyload"

version := "0.1"

organization := "com.ciriscr.lazyload"

scalaVersion := "2.9.1"

seq(webSettings :_*)

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

//LIFT
libraryDependencies ++= {
val liftVersion = "2.4"
  Seq(
  "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container",
  "com.h2database" % "h2" % "1.2.138"
  )
}

// reduce the maximum number of errors shown by the Scala compiler
maxErrors := 30

// increase the time between polling for file changes when using continuous execution
pollInterval := 1000

// append several options to the list of options passed to the Java compiler
//javacOptions ++= Seq("-source", "1.5", "-target", "1.5")

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"


// set the main class for packaging the main jar
// 'run' will still auto-detect and prompt
// change Compile to Test to set it for the test jar
//mainClass in (Compile, packageBin) := Some("myproject.MyMain")

// set the main class for the main 'run' task
// change Compile to Test to set it for 'test:run'
//mainClass in (Compile, run) := Some("myproject.MyMain")


// only use a single thread for building
parallelExecution := true
