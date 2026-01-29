# EasyNav 🧭

**Effortless navigation for Jetpack Compose**

Zero-configuration navigation library for Android. Install, use, ship.

[![Maven Central](https://img.shields.io/maven-central/v/io.github.raulcatalinas.easynav/easynav.svg)](https://search.maven.org/artifact/io.github.raulcatalinas.easynav/easynav)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)

## Installation

```kotlin
dependencies {
    implementation("io.github.raulcatalinas.easynav:easynav:1.0.0")
}
```

## Quick Start

```kotlin
EasyTabNav(
    tabs = listOf(
        TabItem(
            route = "home",
            label = "Home",
            icon = Icons.Default.Home,
            screen = { HomeScreen() }
        ),
        TabItem(
            route = "profile",
            label = "Profile",
            icon = Icons.Default.Person,
            screen = { ProfileScreen() }
        )
    )
)
```

That's it. No NavController, no NavHost, no configuration.

## Why EasyNav?

The Problem:

```kotlin
// 40+ lines of repetitive boilerplate for basic tab navigation  
val navController = rememberNavController()
val navBackStackEntry by navController.currentBackStackEntryAsState()
val currentDestination = navBackStackEntry?.destination

Scaffold(
    bottomBar = {
        NavigationBar {
            items.forEach { item ->
                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any {
                        it.route == item.route
                    } == true,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = { Icon(item.icon, contentDescription = null) },
                    label = { Text(item.label) }
                )
            }
        }
    }
) { paddingValues ->
    NavHost(
        navController = navController,
        startDestination = items.first().route,
        modifier = Modifier.padding(paddingValues)
    ) {
        items.forEach { item ->
            composable(item.route) { item.screen() }
        }
    }
}
```

The Solution:

```kotlin
// 13 lines, readable, maintainable
EasyTabNav(
    tabs = listOf(
        TabItem("home", "Home", Icons.Default.Home) { HomeScreen() },
        TabItem("search", "Search", Icons.Default.Search) { SearchScreen() },
        TabItem("profile", "Profile", Icons.Default.Person) { ProfileScreen() }
    )
)
```

Features  
✅ Zero config - Works immediately, no setup required  
✅ Production ready - Handles state, backstack, and lifecycle correctly  
✅ Type-safe - Compile-time validation  
✅ Material 3 - Follows Android design guidelines  
✅ Lightweight - Minimal overhead, just Navigation Compose under the hood  
✅ Customizable - Sensible defaults, configurable when needed

## Advanced Usage

### Custom Styling

```kotlin
EasyTabNav(
    tabs = myTabs,
    style = TabStyle(
        containerColor = MaterialTheme.colorScheme.surface,
        selectedContentColor = MaterialTheme.colorScheme.primary,
        unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant
    )
)
// Access NavController (When Needed)
val navController = rememberEasyNavController()

EasyTabNav(
    tabs = myTabs,
    navController = navController
)

// Use navController for deep navigation within tabs
Button(onClick = { navController.navigate("details/123") }) {
    Text("View Details")
}
Custom Start Destination
EasyTabNav(
    tabs = myTabs,
    startDestination = "profile" // Defaults to first tab
)
```

## API Reference

### TabItem

```kotlin
data class TabItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null, // Optional different icon when selected
    val screen: @Composable () -> Unit
)
```

### TabStyle

```kotlin
data class TabStyle(
    val containerColor: Color = NavigationBarDefaults.containerColor,
    val selectedContentColor: Color = MaterialTheme.colorScheme.primary,
    val unselectedContentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    val indicatorColor: Color = MaterialTheme.colorScheme.primaryContainer
)
```

## Requirements

Min SDK: 24 (Android 7.0)  
Compile SDK: 34+  
Kotlin: 1.9.0+  
Compose: 1.5.0+

## Roadmap

v1.0 (Current)  
[x] Bottom tab navigation  
[x] Material 3 styling  
[x] State preservation  
v1.1 (Planned)  
[ ] Custom animations  
[ ] Badge support  
[ ] Hide/show behavior on scroll  
v2.0 (Future)  
[ ] Navigation drawer  
[ ] Navigation rail  
[ ] Top app bar navigation

## Contributing

We welcome contributions! Here's how:

- Found a bug? Open an issue
- Have an idea? Start a discussion
- Want to code? Fork, branch, code, PR

See CONTRIBUTING.md for guidelines.

## Development Setup

```bash
git clone https://github.com/yourusername/easynav.git

cd easynav

./gradlew :library:build

# Run sample app
./gradlew :sample:installDebug
````
