package com.trevorwiebe.stackoverflowreader.presentation.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingUiSwitch(
    settingName: String,
    description: String?,
    active: Boolean,
    onCheckChange: (Boolean) -> Unit
) {
    Row {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(5f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = settingName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            if(!description.isNullOrBlank()){
                Text(text = description)
            }
        }
        Switch(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .align(Alignment.CenterVertically),
            checked = active,
            onCheckedChange = {
                onCheckChange(it)
            }
        )
    }
}