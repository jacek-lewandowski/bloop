package bloop

import java.nio.file.{Path, Paths}

import bloop.io.AbsolutePath

case class JdkInstance(javaHome: AbsolutePath, options: Seq[String] = Seq.empty)

object JdkInstance {

  val Default: JdkInstance = {
    val javaHome = Paths.get(sys.props("java.home"))
    val jdkHome = AbsolutePath(if (javaHome.endsWith("jre")) javaHome.getParent else javaHome)
    JdkInstance(jdkHome)
  }
}
