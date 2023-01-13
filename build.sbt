val scala3Version = "3.2.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "Othello",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.14",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test",
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0",
    // libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
    libraryDependencies += ("org.scala-lang.modules" %% "scala-swing" % "3.0.0")
      .cross(CrossVersion.for3Use2_13),
    jacocoCoverallsServiceName := "github-actions",
    jacocoCoverallsBranch := sys.env.get("CI_BRANCH"),
    jacocoCoverallsPullRequest := sys.env.get("GITHUB_EVENT_NAME"),
    jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN")
  )
  .enablePlugins(JacocoCoverallsPlugin)
