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
  .aggregate(meta, codewars, exercism)
  .in(file("."))
  .settings(
    name := "scala3-katabase",
    version := "0.1.0-SNAPSHOT"
  )

lazy val meta = project
  .in(file("meta"))
  .settings(name := "meta", commonSettings)

lazy val codewars = project
  .in(file("codewars"))
  .dependsOn(meta)
  .settings(name := "codewars", commonSettings)

lazy val exercism =
  project
    .in(file("exercism"))
    .dependsOn(meta)
    .settings(name := "exercism", commonSettings)

lazy val inspect =
  project
    .dependsOn(meta, codewars, exercism).settings(commonSettings)
