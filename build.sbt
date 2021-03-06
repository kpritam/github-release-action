import ohnosequences.sbt.GithubRelease.keys.ghreleaseAssets
import ohnosequences.sbt.SbtGithubReleasePlugin
import org.tmt.sbt.docs.DocKeys._

import com.typesafe.sbt.sbtghpages.GhpagesPlugin
import GhpagesPlugin.autoImport._

lazy val aggregatedProjects: Seq[ProjectReference] = Seq(`docs`)

/* ================= Root Project ============== */
lazy val `github-release-action` = project
  .in(file("."))
  .enablePlugins(SbtGithubReleasePlugin)
  .settings(
    scalaVersion := "2.13.2",
    ghreleaseRepoOrg := "kpritam",
    ghreleaseRepoName := "github-release-action",
    ghreleaseAssets := Seq()
  )
  .aggregate(aggregatedProjects: _*)

lazy val docs = project
  .enablePlugins(DocsPlugin)
  .disablePlugins(SbtGithubReleasePlugin)
  .settings(
    ghpagesBranch := "gh-pages",
    docsRepo := "https://github.com/kpritam/kpritam.github.io.git",
    docsParentDir := "github-release-action",
    gitCurrentRepo := "https://github.com/kpritam/github-release-action"
  )
