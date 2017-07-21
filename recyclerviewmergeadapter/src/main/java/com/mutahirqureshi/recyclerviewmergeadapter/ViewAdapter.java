/*
 * Copyright (c) 2017 Muhammad Qureshi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mutahirqureshi.recyclerviewmergeadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ViewsAdapter, ported from CommonsWare SackOfViews adapter https://github.com/commonsguy/cwac-sacklist.
 */
public class ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<View> viewList = new ArrayList<>();

    public ViewAdapter() {
        this(Collections.<View>emptyList());
    }

    public ViewAdapter(@NonNull List<View> viewList) {
        super();
        this.viewList.addAll(viewList);
    }

    @Override
    public int getItemCount() {
        return viewList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // View type is the index in the list of views.
        return new RecyclerView.ViewHolder(viewList.get(viewType)) {};
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {}

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setViews(List<View> views) {
        viewList.clear();
        if (views != null) {
            viewList.addAll(views);
        }
        notifyDataSetChanged();
    }

    public void clear() {
        if (viewList != null) {
            viewList.clear();
        }
        notifyDataSetChanged();
    }

    public void addView(int position, @NonNull View view) {
        viewList.add(position, view);
        notifyItemInserted(position);
    }

    public View removeView(int position) {
        if (position < viewList.size()) {
            final View view = viewList.remove(position);
            notifyItemRemoved(position);
            return view;
        }
        return null;
    }

    public void addView(@NonNull View view) {
        addView(getItemCount(), view);
    }

    public void addViews(List<View> items) {
        if (null == items || items.isEmpty()) return;
        viewList.addAll(items);
        notifyItemRangeInserted(getItemCount() - items.size(), items.size());
    }


    public void moveView(int fromPosition, int toPosition) {
        final View view = viewList.remove(fromPosition);
        viewList.add(toPosition, view);
        notifyItemMoved(fromPosition, toPosition);
    }

    public List<View> getViews() {
        return viewList;
    }
}
