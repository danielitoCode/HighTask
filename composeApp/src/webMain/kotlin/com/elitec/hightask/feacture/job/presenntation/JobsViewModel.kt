package com.elitec.hightask.feacture.job.presenntation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elitec.hightask.feacture.job.domain.GetAllJobsByUserIdCaseUse
import com.elitec.hightask.feacture.job.domain.GetAllJobsCaseUse
import com.elitec.hightask.feacture.job.domain.Job
import com.elitec.hightask.infraestructure.log.AppLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.getScopeName

class JobsViewModel(
    private val getAllJobsCaseUse: GetAllJobsCaseUse,
    private val getAllJobsByUserIdCaseUse: GetAllJobsByUserIdCaseUse
): ViewModel() {
    private fun tag():String = this.getScopeName().type.simpleName ?: ""

    private var _jobsFlow = MutableStateFlow(emptyList<Job>())
    val jobsFlow get() = _jobsFlow.asStateFlow()

    fun initJobsSync(userId: String, role: String) {
        if(userId.isEmpty()) { return }
        viewModelScope.launch {
            when(role=="customuser") {
                true ->  getAllJobsByUserIdCaseUse(userId)
                    .onSuccess { data -> _jobsFlow.value = data  }
                    .onFailure { error -> AppLogger.launchError(tag(), "An error with sync Jobs for userId: $userId \n ERROR -> $error") }
                else -> getAllJobsCaseUse()
                    .onSuccess { data -> _jobsFlow.value = data  }
                    .onFailure { error -> AppLogger.launchError(tag(), "An error with sync Jobs \n ERROR -> $error") }
            }
        }
    }
}