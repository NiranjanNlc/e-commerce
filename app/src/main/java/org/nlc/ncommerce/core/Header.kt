package org.nlc.ncommerce.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.tooling.preview.Preview


// composable functon to genrate the homescreen of the app
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Header()
        Spacer(modifier = Modifier.height(8.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(8.dp))
        HomeTabs()
        Spacer(modifier = Modifier.height(8.dp))
        HomeContent()
    }
}

// composable function to generate the header of the app
@Composable
fun Header() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Text(
            text = "NCommerce",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

// composable function to generate the search bar of the app
@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Search") },
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}

// composable function to generate the home tabs of the app
@Composable
fun HomeTabs() {
    val tabs = listOf("Home", "Cart", "Profile")
    val selectedTabIndex = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex.value,
        modifier = Modifier.fillMaxWidth()
    ) {
        tabs.forEachIndexed { index, text ->
            Tab(
                text = { Text(text) },
                selected = selectedTabIndex.value == index,
                onClick = { selectedTabIndex.value = index }
            )
        }
    }
}

// composable function to generate the home content of the app
@Composable
fun HomeContent() {
    val items = (1..100).toList()
    LazyVerticalGrid(
      columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items.size) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Item $index",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

// composable function to prevew  the home screen preview of the app
@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
