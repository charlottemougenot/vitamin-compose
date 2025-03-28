package com.decathlon.compose.sample.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.decathlon.compose.sample.components.SampleScaffold
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.textinputs.R
import com.decathlon.vitamin.compose.textinputs.TextInputsState
import com.decathlon.vitamin.compose.textinputs.VitaminTextInputs

object TextInputs : Screen {
    override val name: String
        get() = "Text Inputs"

    override val navigationKey: String
        get() = "textinputs"

    @SuppressWarnings("LongMethod", "MagicNumber")
    @Composable
    override fun Screen() {
        SampleScaffold(title = name) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                item {
                    VitaminTextInputs.Outlined(
                        value = "",
                        label = "Label",
                        onValueChange = {}
                    )
                }
                item {
                    VitaminTextInputs.Outlined(
                        value = "Input",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_vtmn_heart_line),
                                contentDescription = null
                            )
                        }
                    )
                }
                item {
                    val expanded = remember { mutableStateOf(false) }
                    val dropdownValue = remember { mutableStateOf("") }
                    VitaminTextInputs.OutlinedDropdown(
                        value = dropdownValue.value,
                        label = "Label",
                        expanded = expanded,
                        children = {
                            PrimaryItem(onClick = {
                                dropdownValue.value = "Label 1"
                                expanded.value = false
                            }) {
                                Text(text = "Option 1")
                            }
                            PrimaryItem(onClick = {
                                dropdownValue.value = "Label 2"
                                expanded.value = false
                            }) {
                                Text(text = "Option 2")
                            }
                        }
                    )
                }
                item {
                    VitaminTextInputs.Outlined(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        colors = TextInputsState.error()
                    )
                }
                item {
                    VitaminTextInputs.Outlined(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        colors = TextInputsState.success()
                    )
                }
                item {
                    VitaminTextInputs.Outlined(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                        enabled = false
                    )
                }
                item {
                    VitaminTextInputs.Outlined(
                        value = "Input",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        enabled = false
                    )
                }
                item {
                    VitaminTextInputs.Filled(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                    )
                }
                item {
                    VitaminTextInputs.Filled(
                        value = "Input",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        icon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_vtmn_heart_line),
                                contentDescription = null
                            )
                        }
                    )
                }
                item {
                    val expanded = remember { mutableStateOf(false) }
                    val dropdownValue = remember { mutableStateOf("") }
                    VitaminTextInputs.FilledDropdown(
                        value = dropdownValue.value,
                        label = "Label",
                        expanded = expanded,
                        children = {
                            PrimaryItem(onClick = {
                                dropdownValue.value = "Label 1"
                                expanded.value = false
                            }) {
                                Text(text = "Option 1")
                            }
                            PrimaryItem(onClick = {
                                dropdownValue.value = "Label 2"
                                expanded.value = false
                            }) {
                                Text(text = "Option 2")
                            }
                        }
                    )
                }
                item {
                    VitaminTextInputs.Filled(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        colors = TextInputsState.error()
                    )
                }
                item {
                    VitaminTextInputs.Filled(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        colors = TextInputsState.success()
                    )
                }
                item {
                    VitaminTextInputs.Filled(
                        value = "",
                        label = "Label",
                        onValueChange = {},
                        enabled = false
                    )
                }
                item {
                    VitaminTextInputs.Filled(
                        value = "Input",
                        label = "Label",
                        onValueChange = {},
                        helperText = "Helper Text",
                        counter = 999 to 999,
                        enabled = false
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputsScreenPreview() {
    VitaminTheme {
        TextInputs.Screen()
    }
}
