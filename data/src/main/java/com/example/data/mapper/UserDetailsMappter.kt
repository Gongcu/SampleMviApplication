package com.example.data.mapper

import com.example.data.dto.UserDetailsEntity
import com.example.domain.model.UserDetails

fun UserDetails.mapperToUserDetailsEntity(): UserDetailsEntity {
    return UserDetailsEntity(
        login,
        name,
        id,
        imageUrl,
        htmlUrl,
        company,
        location,
        followings,
        followers,
    )
}

fun UserDetailsEntity.mapperToUserDetails(): UserDetails {
    return UserDetails(
        this.login,
        this.name,
        this.id,
        this.imageUrl,
        this.htmlUrl,
        this.company,
        this.location,
        this.followings,
        this.followers,
    )
}

