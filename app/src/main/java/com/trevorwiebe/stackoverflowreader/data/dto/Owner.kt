package com.trevorwiebe.stackoverflowreader.data.dto

import com.google.gson.annotations.SerializedName

data class Owner (

    @SerializedName("account_id") var accountId: Int? = null,
    @SerializedName("reputation") var reputation: Int? = null,
    @SerializedName("user_id") var userId: Int? = null,
    @SerializedName("user_type") var userType: String? = null,
    @SerializedName("profile_image") var profileImage: String? = null,
    @SerializedName("display_name") var displayName: String? = null,
    @SerializedName("link") var link: String? = null

)