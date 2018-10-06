package com.memebattle.megahack.main.fragment.request.presentation;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.main.fragment.request.data.model.RequestTask;
import com.memebattle.megahack.main.fragment.request.domain.ApiRequestService;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RecyclerViewRequestsTaskAdapter;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RequestsTask;

import java.util.ArrayList;

import static com.memebattle.megahack.auth.activity.AuthActivity.APP_PREFERENCES;
import static com.memebattle.megahack.auth.activity.AuthActivity.ERROR;
import static com.memebattle.megahack.auth.fragment.sign_in.SignInFragmentPresenter.USER_ID;

@InjectViewState
public class RequestFragmentPresenter extends MvpPresenter <RequestFragmentView> implements RecyclerViewRequestsTaskAdapter.RecyclerCallback {
    public RequestFragmentPresenter(){
        App.apiRequestService.getTasks(new ApiRequestService.ProfileCallback() {
            @Override
            public void onSuccess(RequestTask requestTask) {
                ArrayList<RequestsTask> requestsTaskList = new ArrayList<>();
                requestsTaskList.add(new RequestsTask("",""));
                RecyclerViewRequestsTaskAdapter adapter = new RecyclerViewRequestsTaskAdapter(requestsTaskList);
                adapter.registerRecyclerCallback(RequestFragmentPresenter.this);
                getViewState().updateRecycler(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        }, getStoragePreference());
    }
    private String getStoragePreference(){
        String id = App.app.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE).getString(USER_ID, ERROR);
        return id;
    }

    @Override
    public void onItemClick(String requestId) {

    }
}
