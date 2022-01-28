package com.devndroid.meme.models


/* this is just a data class of memeList

this is created by an pulgin called JSON to Kotlin (install it from settings)
 */
data class MemeList(
    val author: String,
    val nsfw: Boolean,
    val postLink: String,
    val preview: List<String>,
    val spoiler: Boolean,
    val subreddit: String,
    val title: String,
    val ups: Int,
    val url: String
)