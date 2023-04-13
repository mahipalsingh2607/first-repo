package com.example.mygitrepos.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubResponse(
    @Expose
    @SerializedName("GithubResponse")
    val githubResponse: List<GithubResponseItem?>? = null
) : Parcelable

@Parcelize
data class Owner(

    @Expose
    @SerializedName("gists_url")
    val gistsUrl: String? = null,

    @Expose
    @SerializedName("repos_url")
    val reposUrl: String? = null,

    @Expose
    @SerializedName("following_url")
    val followingUrl: String? = null,

    @Expose
    @SerializedName("starred_url")
    val starredUrl: String? = null,

    @Expose
    @SerializedName("login")
    val login: String? = null,

    @Expose
    @SerializedName("followers_url")
    val followersUrl: String? = null,

    @Expose
    @SerializedName("type")
    val type: String? = null,

    @Expose
    @SerializedName("url")
    val url: String? = null,

    @Expose
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String? = null,

    @Expose
    @SerializedName("received_events_url")
    val receivedEventsUrl: String? = null,

    @Expose
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @Expose
    @SerializedName("events_url")
    val eventsUrl: String? = null,

    @Expose
    @SerializedName("html_url")
    val htmlUrl: String? = null,

    @Expose
    @SerializedName("site_admin")
    val siteAdmin: Boolean? = null,

    @Expose
    @SerializedName("id")
    val id: Int? = null,

    @Expose
    @SerializedName("gravatar_id")
    val gravatarId: String? = null,

    @Expose
    @SerializedName("node_id")
    val nodeId: String? = null,

    @Expose
    @SerializedName("organizations_url")
    val organizationsUrl: String? = null
): Parcelable

@Parcelize
data class License(

    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("spdx_id")
    val spdxId: String? = null,

    @Expose
    @SerializedName("key")
    val key: String? = null,

    @Expose
    @SerializedName("url")
    val url: String? = null,

    @Expose
    @SerializedName("node_id")
    val nodeId: String? = null
): Parcelable

@Parcelize
data class GithubResponseItem(

    @Expose
    @SerializedName("allow_forking")
    val allowForking: Boolean? = null,

    @Expose
    @SerializedName("stargazers_count")
    val stargazersCount: Int? = null,

    @Expose
    @SerializedName("is_template")
    val isTemplate: Boolean? = null,

    @Expose
    @SerializedName("pushed_at")
    val pushedAt: String? = null,

    @Expose
    @SerializedName("subscription_url")
    val subscriptionUrl: String? = null,

    @Expose
    @SerializedName("language")
    val language: String? = null,

    @Expose
    @SerializedName("branches_url")
    val branchesUrl: String? = null,

    @Expose
    @SerializedName("issue_comment_url")
    val issueCommentUrl: String? = null,

    @Expose
    @SerializedName("labels_url")
    val labelsUrl: String? = null,

    @Expose
    @SerializedName("subscribers_url")
    val subscribersUrl: String? = null,

    @Expose
    @SerializedName("releases_url")
    val releasesUrl: String? = null,

    @Expose
    @SerializedName("svn_url")
    val svnUrl: String? = null,

    @Expose
    @SerializedName("id")
    val id: Int? = null,

    @Expose
    @SerializedName("has_discussions")
    val hasDiscussions: Boolean? = null,

    @Expose
    @SerializedName("forks")
    val forks: Int? = null,

    @Expose
    @SerializedName("archive_url")
    val archiveUrl: String? = null,

    @Expose
    @SerializedName("git_refs_url")
    val gitRefsUrl: String? = null,

    @Expose
    @SerializedName("forks_url")
    val forksUrl: String? = null,

    @Expose
    @SerializedName("visibility")
    val visibility: String? = null,

    @Expose
    @SerializedName("statuses_url")
    val statusesUrl: String? = null,

    @Expose
    @SerializedName("ssh_url")
    val sshUrl: String? = null,


    @Expose
    @SerializedName("full_name")
    val fullName: String? = null,

    @Expose
    @SerializedName("size")
    val size: Int? = null,

    @Expose
    @SerializedName("languages_url")
    val languagesUrl: String? = null,

    @Expose
    @SerializedName("html_url")
    val htmlUrl: String? = null,

    @Expose
    @SerializedName("collaborators_url")
    val collaboratorsUrl: String? = null,

    @Expose
    @SerializedName("clone_url")
    val cloneUrl: String? = null,

    @Expose
    @SerializedName("name")
    val name: String? = null,

    @Expose
    @SerializedName("pulls_url")
    val pullsUrl: String? = null,

    @Expose
    @SerializedName("default_branch")
    val defaultBranch: String? = null,

    @Expose
    @SerializedName("hooks_url")
    val hooksUrl: String? = null,

    @Expose
    @SerializedName("trees_url")
    val treesUrl: String? = null,

    @Expose
    @SerializedName("tags_url")
    val tagsUrl: String? = null,

    @Expose
    @SerializedName("private")
    val jsonMemberPrivate: Boolean? = null,

    @Expose
    @SerializedName("contributors_url")
    val contributorsUrl: String? = null,

    @Expose
    @SerializedName("has_downloads")
    val hasDownloads: Boolean? = null,

    @Expose
    @SerializedName("notifications_url")
    val notificationsUrl: String? = null,

    @Expose
    @SerializedName("open_issues_count")
    val openIssuesCount: Int? = null,

    @Expose
    @SerializedName("description")
    val description: String? = null,

    @Expose
    @SerializedName("created_at")
    val createdAt: String? = null,

    @Expose
    @SerializedName("watchers")
    val watchers: Int? = null,

    @Expose
    @SerializedName("keys_url")
    val keysUrl: String? = null,

    @Expose
    @SerializedName("deployments_url")
    val deploymentsUrl: String? = null,

    @Expose
    @SerializedName("has_projects")
    val hasProjects: Boolean? = null,

    @Expose
    @SerializedName("archived")
    val archived: Boolean? = null,

    @Expose
    @SerializedName("has_wiki")
    val hasWiki: Boolean? = null,

    @Expose
    @SerializedName("updated_at")
    val updatedAt: String? = null,

    @Expose
    @SerializedName("comments_url")
    val commentsUrl: String? = null,

    @Expose
    @SerializedName("stargazers_url")
    val stargazersUrl: String? = null,

    @Expose
    @SerializedName("disabled")
    val disabled: Boolean? = null,

    @Expose
    @SerializedName("git_url")
    val gitUrl: String? = null,

    @Expose
    @SerializedName("has_pages")
    val hasPages: Boolean? = null,

    @Expose
    @SerializedName("owner")
    val owner: Owner? = null,

    @Expose
    @SerializedName("commits_url")
    val commitsUrl: String? = null,

    @Expose
    @SerializedName("compare_url")
    val compareUrl: String? = null,

    @Expose
    @SerializedName("git_commits_url")
    val gitCommitsUrl: String? = null,


    @Expose
    @SerializedName("blobs_url")
    val blobsUrl: String? = null,

    @Expose
    @SerializedName("git_tags_url")
    val gitTagsUrl: String? = null,

    @Expose
    @SerializedName("merges_url")
    val mergesUrl: String? = null,

    @Expose
    @SerializedName("downloads_url")
    val downloadsUrl: String? = null,

    @Expose
    @SerializedName("has_issues")
    val hasIssues: Boolean? = null,

    @Expose
    @SerializedName("web_commit_signoff_required")
    val webCommitSignoffRequired: Boolean? = null,

    @Expose
    @SerializedName("url")
    val url: String? = null,

    @Expose
    @SerializedName("contents_url")
    val contentsUrl: String? = null,


    @Expose
    @SerializedName("milestones_url")
    val milestonesUrl: String? = null,

    @Expose
    @SerializedName("teams_url")
    val teamsUrl: String? = null,

    @Expose
    @SerializedName("fork")
    val fork: Boolean? = null,

    @Expose
    @SerializedName("issues_url")
    val issuesUrl: String? = null,

    @Expose
    @SerializedName("events_url")
    val eventsUrl: String? = null,

    @Expose
    @SerializedName("issue_events_url")
    val issueEventsUrl: String? = null,

    @Expose
    @SerializedName("assignees_url")
    val assigneesUrl: String? = null,

    @Expose
    @SerializedName("open_issues")
    val openIssues: Int? = null,

    @Expose
    @SerializedName("watchers_count")
    val watchersCount: Int? = null,

    @Expose
    @SerializedName("node_id")
    val nodeId: String? = null,


    @Expose
    @SerializedName("forks_count")
    val forksCount: Int? = null
): Parcelable
