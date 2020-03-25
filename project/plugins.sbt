import sbt.Resolver

scalacOptions ++= Seq(
  "-feature", "-unchecked", "-deprecation",
  "-Xlint:-unused", "-Xfatal-warnings")

resolvers ++= Seq(


  "Typesafe repository".at("https://repo.typesafe.com/typesafe/releases/")
)

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.4")
