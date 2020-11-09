enablePlugins(GraalVMNativeImagePlugin, DockerPlugin)

// For 3.0, waiting on: https://github.com/scalameta/svm-subs/issues/1
scalaVersion := "2.13.3"

libraryDependencies += "org.scalameta" %% "svm-subs" % "20.2.0" % Compile

graalVMNativeImageOptions ++= Seq(
  "--static",
  "--no-server",
  "--no-fallback",
  "--libc=musl",
  "--install-exit-handlers",
)
