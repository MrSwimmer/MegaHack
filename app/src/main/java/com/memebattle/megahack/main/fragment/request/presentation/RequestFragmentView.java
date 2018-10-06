package com.memebattle.megahack.main.fragment.request.presentation;

import com.arellomobile.mvp.MvpView;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RecyclerViewRequestsTaskAdapter;

public interface RequestFragmentView extends MvpView {
    void updateRecycler(RecyclerViewRequestsTaskAdapter adapter);
}
