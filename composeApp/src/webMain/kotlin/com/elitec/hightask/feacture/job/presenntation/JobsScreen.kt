package com.elitec.hightask.feacture.job.presenntation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun JobsScreen(
    modifier : Modifier = Modifier,
    jobsViewModel: JobsViewModel = koinViewModel()
) {
    val jobList by jobsViewModel.jobsFlow.collectAsStateWithLifecycle()

    LazyHorizontalGrid(
        modifier = modifier.fillMaxWidth(),
        rows = GridCells.Fixed(4)
    ) {
        itemsIndexed(jobList) { index, job ->

        }
    }
}