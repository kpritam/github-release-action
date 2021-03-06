import sbt.Keys._
import sbt._
import sbt.plugins.JvmPlugin

object Common extends AutoPlugin {

  override def trigger: PluginTrigger = allRequirements

  override def requires: Plugins = JvmPlugin

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    scalaVersion := "2.13.1",
    resolvers ++= Seq("jitpack" at "https://jitpack.io"),
    version := "0.1.2",
    isSnapshot := !sys.props.get("prod.publish").contains("true"),
    cancelable in Global := true // allow ongoing test(or any task) to cancel with ctrl + c and still remain inside sbt
  )
}
