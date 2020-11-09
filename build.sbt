scalaVersion := "3.0.0-M1"

val maybeImage = sys.env.get("IMAGE_URL").map(_.split("/")).collect {
  case Array(registry, organization, nameAndTag) =>
    val Array(name, tag) = nameAndTag.split(":")
    (registry, organization, name, tag)
}

jibRegistry := maybeImage.map(_._1).getOrElse("index.docker.io")
jibOrganization := maybeImage.map(_._2).getOrElse("library")
jibName := maybeImage.map(_._3).getOrElse("scala-webapp")
jibVersion := maybeImage.map(_._4).getOrElse("jib")
jibBaseImage := "gcr.io/distroless/java"
