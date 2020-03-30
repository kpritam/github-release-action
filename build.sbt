import ohnosequences.sbt.GithubRelease.keys.ghreleaseAssets
import ohnosequences.sbt.SbtGithubReleasePlugin
import org.tmt.sbt.docs.DocKeys._

/* ================= Root Project ============== */
lazy val `github-release-action` = project
  .in(file("."))
  .enablePlugins(SbtGithubReleasePlugin)
  .settings(
    ghreleaseRepoOrg := "kpritam",
    ghreleaseRepoName := "github-release-action",
    ghreleaseAssets := Seq()
  )
