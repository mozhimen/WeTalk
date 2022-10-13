package com.mozhimen.wetalk

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mozhimen.wetalk.ui.theme.WeTalkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeTalkTheme {
                Column() {
                    TabBottomBar()
                }
            }
        }
    }

    @Composable
    private fun TabBottomBar(selectItem: Int) {
        Row {
            TabItem(if (selectItem == 0) R.mipmap.tab_talk_on else R.mipmap.tab_talk_off, "聊天", Modifier.weight(1f))
            TabItem(if (selectItem == 1) R.mipmap.tab_list_on else R.mipmap.tab_list_off, "通讯录", Modifier.weight(1f))
            TabItem(if (selectItem == 2) R.mipmap.tab_round_on else R.mipmap.tab_round_off, "发现", Modifier.weight(1f))
            TabItem(if (selectItem == 3) R.mipmap.tab_mine_on else R.mipmap.tab_mine_off, "我", Modifier.weight(1f))
        }
    }

    @Composable
    private fun TabItem(@DrawableRes id: Int, title: String, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = id), contentDescription = title,
                Modifier.size(24.dp),
                tint = tint
            )
            Text(text = title, fontSize = 11.sp)
        }
    }
}