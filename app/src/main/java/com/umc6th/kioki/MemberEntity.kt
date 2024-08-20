package com.umc6th.kioki

import androidx.room.Entity
import androidx.room.PrimaryKey

// group을 담을 데이터 클래스 -> 통신 시, 엔티티로 변경할 것

@Entity(tableName = "MemberTable")
data class MemberEntity(
    var memberId: Int? = null,
    var userId: Int? = null,
    var profilePictureUrl: Int? = null,
    var nickname: String? = null,
    var noteTitle: String? = null,
    var noteText: String? = null,
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

@Entity(tableName = "NotMemberTable")
data class NotMemberEntity(
    var userId: Int? = null,
    var name: String? = null,
    var phone: String? = null,
    var introduction: String? = null,
    var imageName: String? = null,
    var isGroupMember: Boolean? = null,
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

