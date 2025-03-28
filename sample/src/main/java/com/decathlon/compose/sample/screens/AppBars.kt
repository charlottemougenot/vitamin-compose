package com.decathlon.compose.sample.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.compose.sample.R
import com.decathlon.compose.sample.components.SampleScaffold
import com.decathlon.vitamin.compose.appbars.bottomnavigations.SelectedActionItem
import com.decathlon.vitamin.compose.appbars.bottomnavigations.VitaminBottomNavigations
import com.decathlon.vitamin.compose.appbars.topbars.ActionItem
import com.decathlon.vitamin.compose.appbars.topbars.SearchActionItem
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBarColors
import com.decathlon.vitamin.compose.appbars.topbars.VitaminTopBars
import com.decathlon.vitamin.compose.foundation.VitaminTheme

object AppBars : Screen {
    override val name: String
        get() = "App Bars"
    override val navigationKey: String
        get() = "appbars"

    @OptIn(ExperimentalAnimationApi::class)
    @SuppressWarnings("LongMethod")
    @Composable
    override fun Screen() {
        SampleScaffold(title = name) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    VitaminTopBars.Primary(title = "Vitamin")
                }
                item {
                    VitaminTopBars.Primary(
                        title = "Vitamin",
                        navigationIcon = {
                            Drawer(
                                onClick = {},
                                contentDescription = ""
                            )
                        }
                    )
                }
                item {
                    val expanded = remember { mutableStateOf(false) }
                    VitaminTopBars.Primary(
                        title = "Vitamin",
                        navigationIcon = {
                            Context(
                                onClick = {},
                                contentDescription = "Back"
                            )
                        },
                        actions = arrayListOf(
                            ActionItem(
                                icon = painterResource(R.drawable.ic_vtmn_android_line),
                                contentDescription = null,
                                content = { Text("Android") },
                                onClick = { }
                            ),
                            ActionItem(
                                icon = null,
                                contentDescription = null,
                                content = { Text("Windows") },
                                onClick = { }
                            ),
                            ActionItem(
                                icon = painterResource(R.drawable.ic_vtmn_apple_line),
                                contentDescription = null,
                                content = { Text("Apple") },
                                onClick = { }
                            )
                        ),
                        overflowIcon = {
                            More(
                                onClick = { expanded.value = true },
                                contentDescription = "More",
                            )
                        },
                        expandedMenu = expanded
                    )
                }
                item {
                    val expanded = remember { mutableStateOf(false) }
                    VitaminTopBars.Primary(
                        title = "Vitamin",
                        navigationIcon = {
                            Close(
                                onClick = {},
                                contentDescription = "Close"
                            )
                        },
                        actions = arrayListOf(
                            ActionItem(
                                icon = painterResource(R.drawable.ic_vtmn_android_line),
                                contentDescription = null,
                                content = { Text("Android") },
                                onClick = { }
                            ),
                            ActionItem(
                                icon = null,
                                contentDescription = null,
                                content = { Text("Windows") },
                                onClick = { }
                            ),
                            ActionItem(
                                icon = painterResource(R.drawable.ic_vtmn_apple_line),
                                contentDescription = null,
                                content = { Text("Apple") },
                                onClick = { }
                            )
                        ),
                        overflowIcon = {
                            More(
                                onClick = { expanded.value = true },
                                contentDescription = "More",
                            )
                        },
                        colors = VitaminTopBarColors.contextual(),
                        expandedMenu = expanded,
                    )
                }
                item {
                    val searching = remember { mutableStateOf("") }
                    VitaminTopBars.Search(
                        value = searching.value,
                        placeholder = "Placeholder",
                        onValueChange = {
                            searching.value = it
                        },
                        navigationIcon = {
                            if (searching.value == "") {
                                Search(contentDescription = null)
                            } else {
                                Context(onClick = {}, contentDescription = null)
                            }
                        },
                        actions = arrayListOf(
                            SearchActionItem.Microphone(
                                contentDescription = null,
                                onClick = {}
                            )
                        )
                    )
                }
                item {
                    val searching = remember { mutableStateOf("Search Terms") }
                    VitaminTopBars.Search(
                        value = searching.value,
                        placeholder = "Placeholder",
                        onValueChange = {
                            searching.value = it
                        },
                        navigationIcon = {
                            if (searching.value == "") {
                                Search(contentDescription = null)
                            } else {
                                Context(onClick = {}, contentDescription = null)
                            }
                        },
                        actions = arrayListOf(
                            SearchActionItem.Microphone(
                                contentDescription = null,
                                onClick = {}
                            ),
                            SearchActionItem.Close(
                                contentDescription = null,
                                onClick = {}
                            )
                        )
                    )
                }
                item {
                    val searching = remember { mutableStateOf("") }
                    val searchMode = remember { mutableStateOf(false) }
                    AnimatedContent(
                        targetState = searchMode.value,
                        content = {
                            if (!it) {
                                VitaminTopBars.Primary(
                                    title = "Vitamin",
                                    actions = arrayListOf(
                                        ActionItem(
                                            icon = painterResource(R.drawable.ic_vtmn_search_line),
                                            contentDescription = null,
                                            content = { Text("Search") },
                                            onClick = { searchMode.value = true }
                                        ),
                                    )
                                )
                            } else {
                                VitaminTopBars.Search(
                                    value = searching.value,
                                    placeholder = "Placeholder",
                                    onValueChange = {
                                        searching.value = it
                                    },
                                    navigationIcon = {
                                        if (searching.value == "") {
                                            Search(contentDescription = null)
                                        } else {
                                            Context(onClick = {
                                                searchMode.value = false
                                            }, contentDescription = null)
                                        }
                                    }
                                )
                            }
                        }
                    )
                }
                item {
                    val selectedId = remember { mutableStateOf("android") }
                    VitaminBottomNavigations.Primary(
                        actions = arrayListOf(
                            SelectedActionItem(
                                selected = selectedId.value == "android",
                                icon = painterResource(R.drawable.ic_vtmn_android_line),
                                contentDescription = null,
                                text = "Android",
                                onClick = {
                                    selectedId.value = "android"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "apple",
                                icon = painterResource(R.drawable.ic_vtmn_apple_line),
                                contentDescription = null,
                                text = "Apple",
                                onClick = {
                                    selectedId.value = "apple"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "amazon",
                                icon = painterResource(R.drawable.ic_vtmn_amazon_line),
                                contentDescription = null,
                                text = "Amazon",
                                onClick = {
                                    selectedId.value = "amazon"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "facebook",
                                icon = painterResource(R.drawable.ic_vtmn_facebook_line),
                                contentDescription = null,
                                text = "Facebook",
                                onClick = {
                                    selectedId.value = "facebook"
                                    return@SelectedActionItem true
                                }
                            )
                        )
                    )
                }
                item {
                    val selectedId = remember { mutableStateOf("agenda") }
                    VitaminBottomNavigations.Primary(
                        actions = arrayListOf(
                            SelectedActionItem(
                                selected = selectedId.value == "agenda",
                                icon = painterResource(R.drawable.ic_vtmn_mic_fill),
                                contentDescription = null,
                                text = "Agenda",
                                onClick = {
                                    selectedId.value = "agenda"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "speakers",
                                icon = painterResource(R.drawable.ic_vtmn_mic_fill),
                                contentDescription = null,
                                text = "Speakers",
                                onClick = {
                                    selectedId.value = "speakers"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "networking",
                                icon = painterResource(R.drawable.ic_vtmn_mic_fill),
                                contentDescription = null,
                                text = "Networking",
                                onClick = {
                                    selectedId.value = "networking"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "partners",
                                icon = painterResource(R.drawable.ic_vtmn_mic_fill),
                                contentDescription = null,
                                text = "Partners",
                                onClick = {
                                    selectedId.value = "partners"
                                    return@SelectedActionItem true
                                }
                            ),
                            SelectedActionItem(
                                selected = selectedId.value == "info",
                                icon = painterResource(R.drawable.ic_vtmn_mic_fill),
                                contentDescription = null,
                                text = "Info",
                                onClick = {
                                    selectedId.value = "info"
                                    return@SelectedActionItem true
                                }
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopAppBar() {
    VitaminTheme {
        AppBars.Screen()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDarkTopAppBar() {
    VitaminTheme(darkTheme = true) {
        AppBars.Screen()
    }
}
