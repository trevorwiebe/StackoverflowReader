package com.trevorwiebe.stackoverflowreader.presentation.hotquestionlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HotQuestionItem(
    points: String,
    questionTitle: String,
    category: String,
    tagsList: List<String>,
    onClick: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .padding(8.dp, 4.dp, 8.dp, 4.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .clickable { onClick(questionTitle) }
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .align(Alignment.CenterVertically)
        ){
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .width(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp),
                text = points,
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Column(
            modifier = Modifier.weight(6f)
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp, 8.dp, 8.dp, 0.dp),
                fontWeight = FontWeight.Bold,
                text = questionTitle
            )
            LazyRow{
                items(tagsList){
                    Tag(tag = it)
                }
            }
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = category
            )
        }
    }
}

@Composable
fun Tag(tag: String) {
    Text(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.tertiary)
            .padding(4.dp),
        text = tag,
        color = MaterialTheme.colorScheme.onTertiary
    )
}