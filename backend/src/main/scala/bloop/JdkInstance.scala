package bloop

import bloop.io.AbsolutePath

case class JdkInstance private (jdkHome: AbsolutePath, options: Seq[String] = Seq.empty)

object JdkInstance {

  def apply(javaHome: AbsolutePath, options: Seq[String] = Seq.empty): JdkInstance = {
    val jdkHome = if (javaHome.toString.endsWith("jre")) javaHome.getParent else javaHome
    new JdkInstance(jdkHome, options)
  }

  val Default: JdkInstance = {
    val javaHome = AbsolutePath(sys.props("java.home"))
    JdkInstance(javaHome)
  }
}
