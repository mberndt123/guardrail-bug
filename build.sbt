val http4sVersion = "0.23.24"
scalaVersion := "3.3.1"
Compile / guardrailTasks ++= (Compile / guardrailDiscoveredOpenApiFiles).value.map(f => ScalaClient(f.file, framework="http4s"))
libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-client" % http4sVersion
)