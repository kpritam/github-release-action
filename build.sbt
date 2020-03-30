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
    docsRepo := "git@github.com:kpritam/github-release-action",
    docsParentDir := "github-release-action",
    gitCurrentRepo := "https://github.com/kpritam/github-release-action"
  )
