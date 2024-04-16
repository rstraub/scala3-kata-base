import Dependencies.*
import org.typelevel.scalacoptions.ScalacOptions
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion := "3.4.1"
ThisBuild / organization := "nl.codecraftr"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / javacOptions ++= Seq("-source", "21", "-target", "21")
tpolecatScalacOptions += ScalacOptions.release("21")

lazy val root = project
  .enablePlugins(ScalafmtPlugin)
  .in(file("."))
  .settings(
    name := "scala3-kata-base",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      scalaTest,
      scalaTestJunit,
      scalaCheck,
      approvalsTests,
      mockito,
      catsCore
    )
  )
