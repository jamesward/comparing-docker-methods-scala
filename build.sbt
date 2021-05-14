import com.typesafe.sbt.packager.docker.DockerPermissionStrategy

enablePlugins(LauncherJarPlugin, DockerPlugin)

scalaVersion := "3.0.0"

daemonUserUid in Docker := None
daemonUser in Docker := "root"
dockerPermissionStrategy := DockerPermissionStrategy.None
dockerEntrypoint := Seq("java", "-jar",s"/opt/docker/lib/${(artifactPath in packageJavaLauncherJar).value.getName}")
dockerCmd :=  Seq.empty

val maybeImage = sys.env.get("IMAGE_URL").map(_.split("/")).collect {
  case Array(registry, organization, nameAndTag) =>
    val nameParts = nameAndTag.split(":")
    (registry, organization, nameParts.head, nameParts.lift(1).getOrElse("latest"))
}

dockerRepository := maybeImage.map(_._1)
dockerUsername := maybeImage.map(_._2)
packageName in Docker :=  maybeImage.map(_._3).getOrElse("scala-webapp")
version in Docker := maybeImage.map(_._4).getOrElse("docker")
dockerBaseImage := "gcr.io/distroless/java"
