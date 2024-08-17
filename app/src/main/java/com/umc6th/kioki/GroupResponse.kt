package com.umc6th.kioki

import com.google.gson.annotations.SerializedName

data class UserIdRequest(
    val userId: Int
)

data class GroupMembersPagedResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: GroupMembersResult
)

data class GroupMembersResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: List<GroupMember>
)
// 하나의 그룹만 추가하고 싶은 경우의 DTO
data class GroupMemberResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: String,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: GroupMembersProfilePicture

)

data class GroupMembersResult (
    @SerializedName("groupMemberList") val groupMemberList: List<GroupMember>,
    @SerializedName("listSize") val listSize: Int,
    @SerializedName("totalPage") val totalPage: Int,
    @SerializedName("totalElements") val totalElements: Int,
    @SerializedName("isFirst") val isFirst: Boolean,
    @SerializedName("isLast") val isLast: Boolean
)

data class GroupMember(
    @SerializedName("memberId") val memberId: Int,
    @SerializedName("userId") val userId:Int,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profilePictureUrl") val profilePictureUrl: String,
    @SerializedName("noteTitle") val noteTitle: String,
    @SerializedName("noteText") val noteText: String
)

data class GroupMembersProfilePicture (
    @SerializedName("memberId") val memberId: Int,
    @SerializedName("userId") val userId:Int,
    @SerializedName("nickname") val nickname: String,
    @SerializedName("profilePictureUrl") val profilePictureUrl: String,
    @SerializedName("noteTitle") val noteTitle: String,
    @SerializedName("noteText") val noteText: String,
    @SerializedName("color") val color:String,
    @SerializedName("fontSize") val fontSize: String
)