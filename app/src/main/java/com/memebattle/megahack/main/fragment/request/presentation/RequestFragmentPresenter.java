package com.memebattle.megahack.main.fragment.request.presentation;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.memebattle.megahack.App;
import com.memebattle.megahack.main.fragment.request.presentation.recycler.RecyclerViewRequestsTaskAdapter;
import com.memebattle.megahack.main.fragment.request.data.model.RequestsTask;

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
        requestsTaskList.add(new RequestsTask("Тип 1","Плохо ловит связь в деревне((", "Михаил"));
        requestsTaskList.add(new RequestsTask("Тип 2","текст2", "имя2"));
        requestsTaskList.add(new RequestsTask("Тип 3","текст3", "имя3"));
        requestsTaskList.add(new RequestsTask("Тип 4","текст4", "имя4"));
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
