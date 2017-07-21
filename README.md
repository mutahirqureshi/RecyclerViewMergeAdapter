[![Platform](http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat)](http://developer.android.com/index.html)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![](https://jitpack.io/v/mutahirqureshi/recyclerviewmergeadapter.svg)](https://jitpack.io/#mutahirqureshi/recyclerviewmergeadapter)


RecyclerViewMergeAdapter
========================

The purpose of this merge adapter is to let you use multiple adapters with a RecyclerView instead of only one. 

Download
--------

##### Gradle (JitPack)

In your root build.gradle:
```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

In your project build.gradle:
```
dependencies {
    compile 'com.github.mutahirqureshi:recyclerviewmergeadapter:1.0.1'
}
```

Usage
-----

Add subadapters to the merge adapter and then set it on the RecyclerView. It's also possible to add individual views or a list of views to the merge adapter, using `addView(View... view)` or `addView(List<View> viewList)`

```
RecyclerView myRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

// Create a new merge adapter.
RecyclerViewMergeAdapter mergeAdapter = new RecyclerViewMergeAdapter();

// Add any number of subadapters to the merge adapter.
RecyclerView.Adapter subAdapter1 = new RecyclerView.Adapter();
RecyclerView.Adapter subAdapter2 = new RecyclerView.Adapter();

mergeAdapter.addAdapter(subAdapter1);
mergeAdapter.addAdapter(subAdapter2);

// Set the merge adapter on the RecyclerView.
myRecyclerView.setAdapter(mergeAdapter);
}
```

##### RecyclerViewMergeAdapter methods

- `addAdapter(RecyclerView.Adapter adapter)`
- `addAdapter(int index, RecyclerView.Adapter adapter)`
- `removeAdapter(RecyclerView.Adapter adapter)`
- `removeAdapter(int index)`
- `addView(View... view)`
- `addViews(List<View> views)`
- `getSubAdapterCount()`
- `getSubAdapter(int index)`
- `clearAdapters()`
- `containsAdapter(RecyclerView.Adapter adapter)`


License
-------

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

