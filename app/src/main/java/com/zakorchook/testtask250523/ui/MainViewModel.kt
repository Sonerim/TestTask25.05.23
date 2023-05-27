package com.zakorchook.testtask250523.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zakorchook.testtask250523.Constants
import com.zakorchook.testtask250523.data.db.HistoryDao
import com.zakorchook.testtask250523.data.db.HistoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val historyDao: HistoryDao) : ViewModel() {

    private val _uiState = MutableStateFlow(null as String?)
    val uiState: StateFlow<String?> = _uiState.asStateFlow()

    private val dateFormat by lazy {
        SimpleDateFormat(Constants.UI_DATE_TIME_FORMAT, Locale.US)
    }

    fun requestData() {
        viewModelScope.launch {
            val all = historyDao.getAll()
            _uiState.value = if (all.isEmpty()) null
            else formatDbDataToString(all)
        }
    }

        private fun formatDbDataToString(src: List<HistoryEntity>): String {
            return src.joinToString("\n") { "${it.id} - ${dateFormat.format(it.datetime)}" }
        }
    }