package com.memebattle.megahack.main.fragment.request.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RecyclerViewRequestsTaskAdapter;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RequestsTask;

import java.util.ArrayList;

@InjectViewState
public class RequestFragmentPresenter extends MvpPresenter <RequestFragmentView> implements RecyclerViewRequestsTaskAdapter.RecyclerCallback {
    public RequestFragmentPresenter(){
        /*App.apiRequestService.getTasks(new ApiRequestService.ProfileCallback() {
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
    */
        ArrayList<RequestsTask> requestsTaskList = new ArrayList<>();
        requestsTaskList.add(new RequestsTask("3939338383","33333333", "884883333"));
        RecyclerViewRequestsTaskAdapter adapter = new RecyclerViewRequestsTaskAdapter(requestsTaskList);
        adapter.registerRecyclerCallback(this);
        getViewState().updateRecycler(adapter);
    }
    private String getStoragePreference(){
        return App.settingsService.getUserId();
    }

    @Override
    public void onItemClick(String requestId) {
        getViewState().openNote(requestId);
    }
}
