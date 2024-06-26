import Dependencies.*
import org.typelevel.scalacoptions.ScalacOptions
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion := "3.4.2"
ThisBuild / organization := "nl.codecraftr"

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / javacOptions ++= Seq("-source", "21", "-target", "21")
tpolecatScalacOptions += ScalacOptions.release("21")

lazy val commonSettings =
  libraryDependencies += scalaTest

lazy val root = project
  .enablePlugins(ScalafmtPlugin)
  .aggregate(meta, codewars, exercism, katalog)
  .in(file("."))
  .settings(
    name := "scala3-katabase",
    version := "0.1.0-SNAPSHOT"
  )

lazy val meta = project
  .settings(
    commonSettings
  )

lazy val codewars = project
  .dependsOn(meta)
  .settings(commonSettings)

lazy val exercism =
  project
    .dependsOn(meta)
    .settings(commonSettings)

lazy val katalog =
  project
    .dependsOn(meta)
    .settings(commonSettings)

lazy val inspect =
  project
    .dependsOn(meta, codewars, exercism)
    .settings(
      commonSettings,
      libraryDependencies += "org.reflections" % "reflections" % "0.10.2"
    )
