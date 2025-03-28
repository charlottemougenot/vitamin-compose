# TextInput components

## TextInput design specs

You can find the design specs on [decathlon.design](https://www.decathlon.design/).

## Usage

If you want to use components of this module in your android mobile application, you should 
first add the Gradle dependency in your Gradle file:

```kotlin
implementation("com.decathlon.vitamin.compose:text-inputs:<versions>")
```

### Outlined

```kotlin
object VitaminTextInputs {
    @Composable
    fun Outlined(
        value: String,
        label: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        helperText: String? = null,
        counter: Pair<Int, Int>? = null,
        singleLine: Boolean = false,
        maxLines: Int = Int.MAX_VALUE,
        readOnly: Boolean = false,
        enabled: Boolean = true,
        transformation: VisualTransformation = TextInputsTransformations.none,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        colors: TextInputStateColors = TextInputsState.normal(),
        textStyle: TextStyle = VitaminTheme.typography.body2,
        icon: @Composable (() -> Unit)? = null
    )
}
```

Outlined text input to get an input value from the user.

The minimal usage of the component is the value of your text input, a label associated to it and
the callback to be called when the user type a new character but you can configure yout text
input much more.

```kotlin
VitaminTextInputs.Outlined(
    value = "Input",
    label = "Label",
    onValueChange = {},
    helperText = "Helper Text",
    counter = 999 to 999,
    icon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_vtmn_heart_3_line),
            contentDescription = null
        )
    },
)
```

Parameters | Descriptions
-- | --
`value: String` | The value of your text input
`label: String` | The label to be displayed inside the text input container and pushed at the top of text input when the component takes the focus
`onValueChange: (String) -> Unit` | The callback to be called when the user type a new character
`modifier: Modifier = Modifier` | The `Modifier` to be applied to the component
`helperText: String? = null` | The optional helper text to be displayed at the start bottom outside the text input container
`counter: Pair<Int, Int>? = null` | The optional counter to be displayed the the end bottom outside the text input container
`singleLine: Boolean = false` | True if the text input doesn't extend their height, otherwise, false
`maxLines: Int = Int.MAX_VALUE` | The number of maximum lines the text input can have if the `singleLine` is set to `true`
`readOnly: Boolean = false` | True if you don't want open the keyboard when the user click on the text field
`enabled: Boolean = true` | True if you can type in the text input, otherwise false
`transformation: VisualTransformation = TextInputsTransformations.none` | Transforms the visual representation of the input value
`keyboardOptions: KeyboardOptions = KeyboardOptions.Default` | Software keyboard options that contains such as KeyboardType and ImeAction
`keyboardActions: KeyboardActions = KeyboardActions.Default` | When the text input emit an IME action, the corresponding callback is called
`interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | Representing the stream of interaction for the text input
`colors: TextInputStateColors = TextInputsState.normal()` | The color to notify your user if they are in normal, error or success state
`textStyle: TextStyle = VitaminTheme.typography.body2` | The typography of the text inside the text input
`icon: @Composable (() -> Unit)? = null` | The optional trailing icon to be displayed at the end of the text input container

### Outlined Dropdown

```kotlin
object VitaminTextInputs {
    @Composable
    fun OutlinedDropdown(
        value: String,
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        expanded: MutableState<Boolean> = remember { mutableStateOf(false) },
        colors: TextInputStateColors = TextInputsState.normal(),
        textStyle: TextStyle = VitaminTheme.typography.body2,
        children: @Composable VitaminMenuItems.() -> Unit
    )
}
```

Outlined dropdown to get an input value from a dropdown menu.

The minimal usage of the component is the current value of your text input picked from the dropdown
menu, a label associated to it and the children where you declare your menu items. But you can
configure your text input much more.

```kotlin
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
```

Parameters | Descriptions
-- | --
`value: String` | The value of your text input
`label: String` | The label to be displayed inside the text input container and pushed at the top of text input when the component takes the focus
`modifier: Modifier = Modifier` | The `Modifier` to be applied to the component
`enabled: Boolean = true` | True if you can type in the text input, otherwise false
`expanded: MutableState<Boolean> = remember { mutableStateOf(false) }` | State to open or close the dropdown menu
`interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | Representing the stream of interaction for the text input
`colors: TextInputStateColors = TextInputsState.normal()` | The color to notify your user if they are in normal, error or success state
`textStyle: TextStyle = VitaminTheme.typography.body2` | The typography of the text inside the text input
`children: @Composable VitaminMenuItems.() -> Unit` | Declare your dropdown menu item components inside your dropdown

### Filled

```kotlin
object VitaminTextInputs {
    @Composable
    fun Filled(
        value: String,
        label: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        helperText: String? = null,
        counter: Pair<Int, Int>? = null,
        maxLines: Int = Int.MAX_VALUE,
        singleLine: Boolean = false,
        readOnly: Boolean = false,
        enabled: Boolean = true,
        transformation: VisualTransformation = TextInputsTransformations.none,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        colors: TextInputStateColors = TextInputsState.normal(),
        textStyle: TextStyle = VitaminTheme.typography.body2,
        icon: @Composable (() -> Unit)? = null,
    )
}
```

Filled text input to get an input value from the user.

The minimal usage of the component is the value of your text input, a label associated to it and
the callback to be called when the user type a new character but you can configure yout text
input much more.

```kotlin
VitaminTextInputs.Filled(
    value = "Input",
    label = "Label",
    onValueChange = {},
    helperText = "Helper Text",
    counter = 999 to 999,
    icon = {
        Icon(
            painter = painterResource(id = R.drawable.ic_vtmn_heart_3_line),
            contentDescription = null
        )
    },
)
```

Parameters | Descriptions
-- | --
`value: String` | The value of your text input
`label: String` | The label to be displayed inside the text input container and pushed at the top of text input when the component takes the focus
`onValueChange: (String) -> Unit` | The callback to be called when the user type a new character
`modifier: Modifier = Modifier` | The `Modifier` to be applied to the component
`helperText: String? = null` | The optional helper text to be displayed at the start bottom outside the text input container
`counter: Pair<Int, Int>? = null` | The optional counter to be displayed the the end bottom outside the text input container
`singleLine: Boolean = false` | True if the text input doesn't extend their height, otherwise, false
`maxLines: Int = Int.MAX_VALUE` | The number of maximum lines the text input can have if the `singleLine` is set to `true`
`readOnly: Boolean = false` | True if you don't want open the keyboard when the user click on the text field
`enabled: Boolean = true` | True if you can type in the text input, otherwise false
`transformation: VisualTransformation = TextInputsTransformations.none` | Transforms the visual representation of the input value
`keyboardOptions: KeyboardOptions = KeyboardOptions.Default` | Software keyboard options that contains such as KeyboardType and ImeAction
`keyboardActions: KeyboardActions = KeyboardActions.Default` | When the text input emit an IME action, the corresponding callback is called
`interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | Representing the stream of interaction for the text input
`colors: TextInputStateColors = TextInputsState.normal()` | The color to notify your user if they are in normal, error or success state
`textStyle: TextStyle = VitaminTheme.typography.body2` | The typography of the text inside the text input
`icon: @Composable (() -> Unit)? = null` | The optional trailing icon to be displayed at the end of the text input container

### Filled Dropdown

```kotlin
object VitaminTextInputs {
    @Composable
    fun FilledDropdown(
        value: String,
        label: String,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        expanded: MutableState<Boolean> = remember { mutableStateOf(false) },
        colors: TextInputStateColors = TextInputsState.normal(),
        textStyle: TextStyle = VitaminTheme.typography.body2,
        children: @Composable VitaminMenuItems.() -> Unit
    )
}
```

Filled dropdown to get an input value from a dropdown menu.

The minimal usage of the component is the current value of your text input picked from the dropdown
menu, a label associated to it and the children where you declare your menu items. But you can
configure your text input much more.

```kotlin
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
```

Parameters | Descriptions
-- | --
`value: String` | The value of your text input
`label: String` | The label to be displayed inside the text input container and pushed at the top of text input when the component takes the focus
`modifier: Modifier = Modifier` | The `Modifier` to be applied to the component
`enabled: Boolean = true` | True if you can type in the text input, otherwise false
`expanded: MutableState<Boolean> = remember { mutableStateOf(false) }` | State to open or close the dropdown menu
`interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }` | Representing the stream of interaction for the text input
`colors: TextInputStateColors = TextInputsState.normal()` | The color to notify your user if they are in normal, error or success state
`textStyle: TextStyle = VitaminTheme.typography.body2` | The typography of the text inside the text input
`children: @Composable VitaminMenuItems.() -> Unit` | Declare your dropdown menu item components inside your dropdown
