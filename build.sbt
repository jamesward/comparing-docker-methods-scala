enablePlugins(GraalVMNativeImagePlugin, DockerPlugin)

name := "comparing-docker-methods-scala"

scalaVersion := "3.0.0"

graalVMNativeImageOptions ++= Seq(
  "--static",
  "--no-server",
  "--no-fallback",
  "--libc=musl",
  "--install-exit-handlers",
)
