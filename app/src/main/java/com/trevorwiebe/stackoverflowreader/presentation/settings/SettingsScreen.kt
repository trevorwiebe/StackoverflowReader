package com.trevorwiebe.stackoverflowreader.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingsScreen(
    paddingValues: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        
        SettingUiSwitch(
            settingName = "Filter out HTML entities",
            description = "Enable this to remove HTML entities that can end up in the text to be narrated.",
            active = true,
            onCheckChange = {}
        )
        Divider()
        SettingUiSwitch(
            settingName = "Remove links",
            description = "Enabling this remove the URLs from the text to be narrated.",
            active = true,
            onCheckChange = {}
        )
        Divider()
    }
}