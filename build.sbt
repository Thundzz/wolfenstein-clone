name := "game-engine-tutorial"

organization := "com.base"

version := "1.0-SNAPSHOT"

val folderName =
  if (System.getProperty("os.name").startsWith("Windows")) "windows" else "linux"

val libPath = Seq(s"lib/native/$folderName").mkString(java.io.File.pathSeparator)

javaOptions in run += s"-Djava.library.path=$libPath"

description := "Game engine tutorial project"
publishMavenStyle := true
crossPaths := false

autoScalaLibrary := false



