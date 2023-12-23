package com.trevorwiebe.stackoverflowreader.data.dto

import com.google.gson.annotations.SerializedName

data class ComplexQuestionDto (

    @SerializedName("items") var items : ArrayList<Items> = arrayListOf(),
    @SerializedName("has_more") var hasMore : Boolean? = null,
    @SerializedName("quota_max") var quotaMax : Int? = null,
    @SerializedName("quota_remaining") var quotaRemaining : Int? = null

)