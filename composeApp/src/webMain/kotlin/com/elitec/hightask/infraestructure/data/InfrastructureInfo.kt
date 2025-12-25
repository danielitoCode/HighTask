package com.elitec.hightask.infraestructure.data

object InfrastructureInfo {
    const val GOOGLE_WEB_CLIENT_ID = "544596382442-3idph1mhp326se76lsfd0092fcnhmvg8.apps.googleusercontent.com"

    object AppWriteConfig {
        val appWriteEndpoint get() = "nyc.cloud.appwrite.io/v1"
        val appWriteProjectId get() = "68f990d4002b6960ecf9"
        val appWriteDatabaseId get() = "6941cf370039241b346f"
        val appWriteJobsTableId get() = "userjob"
    }
}