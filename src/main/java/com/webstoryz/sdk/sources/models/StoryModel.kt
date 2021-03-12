package com.webstoryz.sdk.sources.models

class StoryModel(
    val subtitle: String?,
    val duration: Int?,
    val iconUrl: String?,
    val title: String?,
    val url: String?,
    val id: String?,
    val type: String?,
    val thumbUrl: String?,
    val borderColor: String?
)

class StoriesData(
    val stories: Array<StoryModel>,
    val title: String?,
    val style: String?
)

class StoryResult(
    val success: Boolean?,
    val data: StoriesData?
)